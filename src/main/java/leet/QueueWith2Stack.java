package leet;

import java.util.Stack;

public class QueueWith2Stack {

    public static void main(String[] args) {
        StackyQueue queue = new StackyQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);


        System.out.println(queue.dequeue()); // Outputs 1
        System.out.println(queue.peek());    // Outputs 2
        System.out.println(queue.dequeue()); // Outputs 2
        System.out.println(queue.isEmpty()); // Outputs false
        System.out.println(queue.dequeue()); // Outputs 3
        System.out.println(queue.isEmpty()); // Outputs true
    }

}


class StackyQueue {
    private Stack<Integer> first = new Stack<>();
    private Stack<Integer> second = new Stack<>();

    public void enqueue(int i) {
        first.push(i);
    }

    public int dequeue() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }

        if (second.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return second.pop();
    }

    public int peek() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }

        if (second.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return second.peek();
    }

    public boolean isEmpty() {
        return second.isEmpty() && first.isEmpty();
    }
}
