package cuncurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSample {

    private CountDownLatch secondLatch = new CountDownLatch(1);
    private CountDownLatch thirdLatch = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        secondLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondLatch.await();
        printSecond.run();
        thirdLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdLatch.await();
        printThird.run();
    }
}


class TestFunctionality {
    public static void main(String[] args) {
        CountDownLatchSample countDownLatchSample = new CountDownLatchSample();

        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");

        Thread thread1 = new Thread(() -> {
            try {
                countDownLatchSample.first(printFirst);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                countDownLatchSample.second(printSecond);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                countDownLatchSample.third(printThird);
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