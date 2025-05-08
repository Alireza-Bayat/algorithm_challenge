package cuncurrency.sample;

public class Thread_Runnable {

    public static class ThreadSample1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable is running");
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable is running in a anonymous class");
            }
        };

        Runnable runnableLambda = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Runnable is running in a Lambda expression " + name);
        };

        Thread t = new Thread(new ThreadSample1());
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnableLambda);
        System.out.println("Main thread start");
        t.start();
        t2.start();
        t3.start();
        System.out.println("Main thread end");
    }
}
