public class LinkedListDeque<T> {
    private Node sentinel;
    private int Size;

    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node (Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null ,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        Size = 0;
    }

    public LinkedListDeque(T i) {
        sentinel = new Node(null, null , null);
        sentinel.prev = sentinel.next = new Node(sentinel, i, sentinel);
        Size = 1;
    }



    public void addFirst(T item) {
        Node tmp = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = tmp;
        sentinel.next = tmp;
        Size += 1;
    }

    public void addLast(T item) {
        Node tmp = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = tmp;
        sentinel.prev = tmp;
        Size += 1;
    }

    public boolean isEmpty() {
        if (Size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return Size;
    }

    public void printDeque() {
        for(Node i = sentinel.next; i != sentinel ; i = i.next ) {
            System.out.print(i.item + " ");
        }
        System.out.println();
    }

    public T removeFirst(){
        if(Size == 0) {
            return null;
        }
        Node tmp = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        Size -= 1;
        return tmp.item;
    }

    public T removeLast() {
        if(Size == 0) {
            return null;
        }
        Node tmp = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        Size -= 1;
        return tmp.item;
    }

    public T get(int index) {
        if(index > Size + 1) {
            return null;
        }
        Node tmp = sentinel.next;
        while(index > 0) {
            tmp = tmp.next;
            index -= 1;
        }
        return tmp.item;
    }

    public T getRecursive(int index){
        return getRecursiveHelper(sentinel, index);
    }

    private T getRecursiveHelper(Node n, int index) {
        Node tmp = n.next;
        if(index == 0) {
            return tmp.item;
        }
        return getRecursiveHelper(n.next, index-1 );
    }

    public LinkedListDeque(LinkedListDeque other) {
        for(int i = other.Size; i > 0 ; i--) {
            T item_o = (T) other.get(i);
            this.addFirst(item_o);
        }
    }


//    public static void main(String[] args) {
////        LinkedListDeque<Integer> L= new LinkedListDeque<>(2);
//        LinkedListDeque<Integer> EL= new LinkedListDeque<>();
//        EL.addFirst(1);
//        int a = 1;
//        System.out.print(a + " ");
//        if(3 > a + 1) {
//            System.out.print("a");
//        }
//            System.out.println();
//
////        System.out.println(EL.Size);
////        System.out.println(L.sentinel.next.next.item);
//    }
}
