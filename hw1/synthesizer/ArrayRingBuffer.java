package synthesizer;
import java.util.Iterator;
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    private class ArbIterator implements Iterator<T> {
        private int ptr;
        private int num;
        public ArbIterator() {
            ptr = first;
            num = 0;
        }
        public boolean hasNext() {
            return num < capacity();
        }

        public T next() {
            T returnItem = rb[ptr];
            ptr = (ptr + 1) % capacity();
            num++;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new ArbIterator();
    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
        fillCount = 0;
        first = 1;
        last = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (fillCount() < capacity()) {
            if (last == capacity() - 1) {
                last = -1;
            }
            rb[last + 1] = x;
            last += 1;
            fillCount++;
        } else {
            throw new RuntimeException("Cannot add element to a full array!");
        }
    }


    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (fillCount() > 0) {
            T fir = rb[first];
            rb[first] = null;
            first++;
            fillCount--;
            if (first == capacity()) {
                first = 0;
            }
            return fir;
        } else {
            throw new RuntimeException("Cannot remove element from an empty array!");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (rb[first] == null) {
            throw new RuntimeException("Cannot get the peek of an empty array!");
        }
        return rb[first];
    }
}
