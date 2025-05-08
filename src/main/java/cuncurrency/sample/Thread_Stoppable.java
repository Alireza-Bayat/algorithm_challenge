package cuncurrency.sample;

public class Thread_Stoppable implements Runnable {

    private boolean stopExecution = false;

    public synchronized void requestStop() {
        this.stopExecution = true;
    }

    public synchronized boolean isStopExecution() {
        return stopExecution;
    }

    private void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println("Stoppable_Thread_Running");
        while (!isStopExecution()) {
            sleep(1000);
            System.out.println(" NOT YET STOPPED");
        }
        System.out.println("Stoppable_Thread_Ends");
    }
}

class Main {

    public static void main(String[] args) {
        Thread_Stoppable thread_stoppable = new Thread_Stoppable();
        Thread thread = new Thread(thread_stoppable, "STOPPABLE");
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread_stoppable.requestStop();
        System.out.println("main thread stopping");
    }
}