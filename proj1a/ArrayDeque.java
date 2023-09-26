public class ArrayDeque <T>{
    private T a[];
    private int size;

    private int containerSize;
    public ArrayDeque(){
        a = (T[]) new Object[8];
        containerSize = 8;
        size = 0;
    }
    public void addFirst(T item){
        if (size == 0) {
            a[0] = item;
        }else if(size < containerSize){
            for (int i = size; i > 0; i--){
                a[i] = a[i - 1];
            }
            a[0] = item;
        } else{
            T[] newa = expend();
            for(int i = size; i > 0; i--){
                newa[i] = a[i - 1];
            }
            newa[0] = item;
            a = newa;
        }
        size += 1;
    }
    public void addLast(T item){
        if(size < containerSize){
            a[size] = item;
        } else{
            T[] newa = expend();
            for (int i = 0; i < size ; i ++){
                newa[i] = a[i];
            }
            newa[size] = item;
            a = newa;
        }
        size += 1;
    }
    private T[] expend(){
        containerSize = 2 * containerSize;
        T newa [] = (T[]) new Object[containerSize];
        return newa;
    }
    public boolean isEmpty(){
        if (size == 0){
            return true;
        } else{
            return false;
        }
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for (int i = 0; i < size; i ++){
            System.out.print(a[i]);
            if (i != size - 1){
                System.out.print(' ');
            }
        }
    }
    public T removeFirst(){
        if (size == 0){
            return null;
        } else {
            T first = a[0];
            for (int i = 0; i < size - 1; i++) {
                a[i] = a[i + 1];
            }
            a[size - 1] = null;
            size -= 1;
            return first;
        }
    }
    public T removeLast(){
        if (size == 0){
            return null;
        } else {
            T last = a[size - 1];
            a[size - 1] = null;
            size -= 1;
            return last;
        }
    }
    public T get(int index){
        T theItem = a[index];
        return theItem;
    }
    /*public static void main(String[] args){
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        l.addFirst(4);
        l.addFirst(5);
        l.addFirst(6);
        l.addFirst(7);
        l.addFirst(8);
        l.addFirst(9);
        l.addLast(10);
        System.out.println(l.removeFirst());
        l.printDeque();
    }*/
}
