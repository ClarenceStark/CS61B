package synthesizer;
//package <package name>;
//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        //Random random = new Random();
        int capacity = (int) (Math.round(SR / frequency));
        buffer = new ArrayRingBuffer<>(capacity);
        //ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(capacity);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.enqueue(0.0);
        }
        //for (int i = 0; i < capacity; i ++) {
        //    arb.enqueue(random.nextDouble(-0.5, 0.5));
        //}
        //double temp = arb.dequeue();
        //arb.enqueue((temp + arb.peek()) * 0.5 * DECAY);
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.dequeue();
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        double temp = buffer.dequeue();
        buffer.enqueue((temp + buffer.peek()) * 0.5 * DECAY);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
