import java.util.Arrays;

public class ArrayStack<Item> implements Stack<Item> {
    private Item[] items;
    private int size;
    public ArrayStack() {
        items = (Item[]) new Object[8];
        size = 0;
    }
    public void resize(int capacity) {
        Item[] newItems = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, Math.min(items.length, capacity));
        items = newItems;
    }
    @Override
    public void push(Item x) {
        if (usageRatio() == 1) {
            resize(2 * items.length);
        }
        items[size] = x;
        size += 1;
    }
    @Override
    public Item pop() {
        if (size() == 0) {
            return null;
        }
        if (usageRatio() < 0.25 && items.length > 8) {
            resize(items.length / 2);
        }
        Item last = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return last;
    }
    @Override
    public int size() {
        return size;
    }
    private double usageRatio() {
        return ((double) size()) / items.length;
    }
    public void printItems() {
        for (int i = 0; i < size(); i ++) {
            System.out.print(items[i] + " ");
        }
    }
}
