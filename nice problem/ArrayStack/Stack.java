public interface Stack<Item> {
    void push(Item x);
    Item pop();
    int size();
    default void purge(Item x) {
        if (size() == 0) {
            return;
        } else {
            Item top = pop();
            purge(x);
            if (!x.equals(top)) {
                push(top);
            }
        }
    }
}
