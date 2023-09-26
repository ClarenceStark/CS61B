public class LinkedListDeque<T>{
    //Adds an item of type T to the front of the deque
    private int size = 0;

    private class Tnode<T>{
        T item;
        Tnode next;
        Tnode last;
        private Tnode(T i, Tnode l, Tnode n){
            item = i;
            last = l;
            next = n;
        }
    }
    private Tnode fakeFirst;
    private Tnode fakeLast;
    T passer;

    public int index = 0;
    public LinkedListDeque() {
        fakeFirst = new Tnode(passer, null, null);
        fakeLast = new Tnode(passer, null, null);
        fakeFirst.next = fakeLast;
        fakeLast.last = fakeFirst;
    }
    public void addFirst(T item){
        Tnode t  = new Tnode(item, fakeFirst, fakeFirst.next);
        fakeFirst.next = t;
        size += 1;
    }
    //Adds an item of type T to the back of the deque
    public void addLast(T item){
        Tnode t = new Tnode(item, fakeLast.last, fakeLast);
        fakeLast.last = t;
        size += 1;
    }
    //Returns true if deque is empty, false otherwise
    public boolean isEmpty(){
        if (fakeFirst.next == fakeLast) {
            return true;
        }else {
            return false;
        }
    }
    //Returns the number of items in the deque.
    public int size(){
        return size;
    }
    //Prints the items in the deque from first to last, separated by a space
    public void printDeque(){
        Tnode temp = fakeFirst;
        while (temp.next != fakeLast){
            System.out.print(temp.next.item);
            if (temp.next.next != fakeLast) {
                System.out.print(' ');
            }
            temp = temp.next;
        }
    }
    //Removes and returns the item at rhe front of the deque. If no such item exists, returns null.
    public T removeFirst(){
        if (this.isEmpty() == true){
            return null;
        } else {
            T item = (T) fakeFirst.next.item;
            fakeFirst.next = fakeFirst.next.next;
            fakeFirst.next.next.last = fakeFirst;
            return item;
        }
    }
    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeLast(){
        if (this.isEmpty() == true){
            return null;
        } else {
            T item = (T) fakeLast.last.item;
            fakeLast.last = fakeLast.last.last;
            fakeLast.last.last.next = fakeLast;
            return item;
        }
    }
    //Gets the item at the given index, where 0 is the front, 1 is the next item. and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        Tnode temp = fakeFirst.next;
        if (temp == fakeLast){
            return null;
        }
        for (int i = 0; i < index; i++){
            temp = temp.next;
            if (temp == fakeLast){
                return null;
            }
        }
        return (T)temp.item;
    }
    public T getRecursiveHelper(Tnode t, int i){
        if (t == fakeLast){
            return null;
        }
        if (i == index){
            return (T)t.item;
        } else{
            index += 1;
            return (T)getRecursiveHelper(t.next, i);
        }
    }
    public  T getRecursive(int index){
       return (T)getRecursiveHelper(fakeFirst.next, index);
    }
    /*public static void main(String[] args){
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        l.addFirst(3);
        l.addFirst(4);
        l.addFirst(5);
        System.out.println(l.getRecursive(6));
    }*/
}
