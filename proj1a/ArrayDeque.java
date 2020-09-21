public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextfirst;
    private int nextlast;

    public ArrayDeque() {
        items = (T[]) new Object [8];
        size = 0;
        int pointer = items.length / 2;
        nextfirst = pointer;
        nextlast = pointer + 1;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object [other.size];

        size = 0;

        if ((other.nextlast > other.nextfirst) && (other.size != other.items.length)) {
            System.arraycopy(other.items, other.nextfirst + 1, items, 1, size);
            size += other.size;
            nextfirst = items.length - 1;
            nextlast = size;
        } else {
            System.arraycopy(other.items, other.nextfirst + 1, items, 0, other.items.length - other.nextfirst - 1);
            System.arraycopy(other.items, 0, items, other.items.length - other.nextfirst - 1, other.nextlast);
            size += other.size;
            nextfirst = items.length - 1;
            nextlast = size;
        }


    }

    private int onePlus(int index) {
        if (index == items.length - 1) {
            index = 0;
        } else {
            index += 1;
        }
        return index;
    }

    private int oneMinus(int index) {
        if (index == 0) {
            index = items.length - 1;
        } else {
            index -= 1;
        }
        return index;
    }

    public void addFirst(T i) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextfirst] = i;
        nextfirst = oneMinus(nextfirst);

//        System.arraycopy(items, 0, items, 1, size);
//        items[0] = i;
        size += 1;
    }

    public void addLast(T i) {
        if (size == items.length) {
            resize(size * 2);
        }
//        items[size] = i;
        items[nextlast] = i;
        nextlast = onePlus(nextlast);
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
//        for (int i = 0; i < size; i++) {
//            System.out.print(items[i] + " ");
//        }
//        System.out.println();
        if ((nextlast > nextfirst) && (size != items.length)) {
            for (int i = nextfirst + 1; i < nextlast; i++) {
                System.out.println(items[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = nextfirst + 1; i < items.length; i++) {
                System.out.println(items[i] + " ");
            }
            for (int i = 0; i < nextlast; i++) {
                System.out.println(items[i] + " ");
            }
            System.out.println();
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextfirst = onePlus(nextfirst);
        T tmp = items[nextfirst];
        items[nextfirst] = null;
        size -= 1;
        if (size > 16 && ((float) size / items.length < 0.25)) {
            resize(size / 2);
        }
        return tmp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextlast = oneMinus(nextlast);
        T tmp = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        if (size > 16 && ((float) size / items.length < 0.25)) {
            resize(size / 2);
        }
        return tmp;

    }

    public T get(int Index) {
        int tmp = nextfirst;
        for (int i = 0; i <= Index; i++) {
            tmp = onePlus(tmp);
        }
        return items[tmp];
    }

    private void resize(int Index) {
        T[] tmp = (T[]) new Object[Index];
        if ((nextlast > nextfirst) && (size != items.length)) {
            System.arraycopy(items, nextfirst + 1, tmp, 0, size);
            nextfirst = Index - 1;
            nextlast = size;
        } else {
            System.arraycopy(items, nextfirst + 1, tmp, 0, items.length - nextfirst - 1);
            System.arraycopy(items, 0, tmp, items.length - nextfirst, nextlast);
            nextfirst = Index - 1;
            nextlast = size;
        }
        items = tmp;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for (int i = 0; i < 9 ; i++) {
            ad.addFirst(10);
        }
        ArrayDeque<Integer> ad1 = new ArrayDeque<>(ad);
        ad1.removeFirst();
        ad1.removeLast();
//        System.out.println(ad1.nextlast);
//        System.out.println(ad1.nextfirst);
        System.out.println(ad1.size());
    }
}
