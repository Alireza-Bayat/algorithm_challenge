package designPattern.cleaner;


import java.lang.ref.Cleaner;

/**
 * @author alireza_bayat
 * created on 2/5/23
 */
public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();
    // Resource that requires cleaning. Must not refer to Room!
    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in this room
        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }
        // Invoked by close method or cleaner
        @Override public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }
    // The state of this room, shared with our cleanable
    private final State state;
    // Our cleanable. Cleans the room when it’s eligible for gc
    private final Cleaner.Cleanable cleanable;
    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
    @Override public void close() {
        cleanable.clean();
    }
}

class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
}

class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("Peace out");
    }
}
