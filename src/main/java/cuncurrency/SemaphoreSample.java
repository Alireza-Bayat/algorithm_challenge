package cuncurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    private Semaphore secondSemaphore = new Semaphore(0);
    private Semaphore thirdSemaphore = new Semaphore(0);


    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        secondSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondSemaphore.acquire();
        printSecond.run();
        thirdSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdSemaphore.acquire();
        printThird.run();
    }
}

class TestFunctionalitySemaphoreSample {
    public static void main(String[] args) {
        SemaphoreSample semaphoreSample = new SemaphoreSample();

        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");

        Thread thread1 = new Thread(() -> {
            try {
                semaphoreSample.first(printFirst);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                semaphoreSample.second(printSecond);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                semaphoreSample.third(printThird);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

