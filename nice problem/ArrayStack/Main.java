public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.purge(2);
        arrayStack.printItems();
    }
}
