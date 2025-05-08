package cuncurrency.sample;

public class Thread_Thread {

    public static class ThreadSample1 extends Thread{
        @Override
        public void run() {
            System.out.println("Thread is running");
        }
    }

    public static void main(String[] args) {
        ThreadSample1 threadSample1 = new ThreadSample1();
        System.out.println("Main thread start");
        threadSample1.start();
        System.out.println("Main thread end");
    }
}
