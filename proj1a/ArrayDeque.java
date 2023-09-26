public class ArrayDeque <T>{
    private T a[];
    private int size;
    private int firstIndex;
    private int containerSize;
    public ArrayDeque(){
        a = (T[]) new Object[8];
        containerSize = 8;
        firstIndex = 4;
        size = 0;
    }
    private int minusOne(int Index){
            return Index - 1;
    }
    private void expend(){
        containerSize = 2 * containerSize;
        T [] expendedt = (T[]) new Object[containerSize];
        int newfirstIndex = (containerSize - size) / 2;
        for (int i = 0; i < size; i++){
            expendedt[i + newfirstIndex] = a[firstIndex + i];
        }
        firstIndex = newfirstIndex;
        a = expendedt;
    }
    public void addFirst(T item){
        if (firstIndex == 0){
            expend();
        }
        firstIndex = minusOne(firstIndex);
        a[firstIndex] = item;
        size ++;
    }
    public void addLast(T item){
        if (firstIndex + size == containerSize - 1){
            expend();
        }
        a[firstIndex + size] = item;
        size ++;
    }
    /*private T[] expend(){
        containerSize = 2 * containerSize;
        T newa [] = (T[]) new Object[containerSize];
        return newa;
    }*/
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
        for (int i = firstIndex; i < firstIndex + size; i ++){
            System.out.print(a[i]);
            if (i != firstIndex + size - 1){
                System.out.print(' ');
            }
        }
    }
    public T removeFirst(){
        if (size == 0){
            return null;
        } else {
            T theFirst = a[firstIndex];
            firstIndex += 1;
            size -= 1;
            return theFirst;
        }
    }
    public T removeLast(){
        if (size == 0){
            return null;
        } else {
            T theLast = a[firstIndex + size - 1];
            size -= 1;
            return theLast;
        }
    }
    public T get(int index){
        T theItem = a[firstIndex + index];
        return theItem;
    }
    /*public static void main(String[] args){
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        l.addFirst(4);
        l.addLast(7);
        l.addLast(9);
        l.addLast(0);
        l.printDeque();
        l.removeLast();
        System.out.println(" ");
        l.printDeque();
        l.removeFirst();
        System.out.println(" ");
        l.printDeque();
        System.out.println(l.get(3));
    }*/
}
