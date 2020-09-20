public class ArrayDeque<T> {
    public T[] items;
    private int Size;

    public ArrayDeque() {
        items = (T[]) new Object [8];
        Size = 0;
    }

//    public ArrayDeque(T[] i) {
//        items = (T[]) new Object[8];
//        System.arraycopy(i, 0, items, 0, i.length);
//        Size += i.length;
//    }

    public void addFirst(T i) {
        if(Size == items.length) {
            resize(Size * 2);
        }
        System.arraycopy(items, 0, items, 1 , Size );
        items[0] = i;
        Size += 1;
    }

    public void addLast(T i) {
        if(Size == items.length) {
            resize(Size * 2);
        }
        items[Size] = i;
        Size += 1;
    }

    public boolean isEmpty() {
        if(Size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return Size;
    }

    public void printDeque() {
        for(int i =0 ; i < Size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if(Size == 0) {
            return null;
        }
        if(Size > 16 && ((float)Size / items.length < 0.25)) {
            resize(Size / 2);
        }
        T tmp = items[0];
        Size -= 1;
        System.arraycopy(items, 1 , items, 0, Size);
        return tmp;
    }

    public T removeLast() {
        if(Size == 0) {
            return null;
        }
        if(Size > 16 && ((float)Size / items.length < 0.25)) {
            resize(Size / 2);
        }
        T tmp = items[Size-1];
        items[Size-1] = null;
        Size -= 1;
        return tmp;

    }

    public T get(int Index) {
        return items[Index];
    }

    public ArrayDeque(ArrayDeque other) {
        System.arraycopy(other, 0, items, 0, other.Size);
    }

    public void resize(int Index) {
        T[] tmp = (T[]) new Object[Index];
        System.arraycopy(items, 0 , tmp , 0, Size);
        items = tmp;
    }


//    public static void main(String[] args) {
//        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
//        ad1.addFirst(100);
//        int tr = ad1.removeFirst();
//
//        System.out.print(tr);
//        System.out.println((float)1/4);
//
//    }

}
