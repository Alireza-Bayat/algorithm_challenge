package cuncurrency.sample;

import java.util.function.Supplier;

public class Thread_ThreadLocal {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(new Supplier<String>() {
            @Override
            public String get() {
                return "INITIAL VALUE";
            }
        });

        ThreadLocal<String> inheritedThreadLocal = new InheritableThreadLocal<>() {
            @Override
            protected String initialValue() {
                return "InheritedThreadLocal initial value";
            }
        };
        Thread thread = new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            inheritedThreadLocal.set(Thread.currentThread().getName());
            System.out.println("thread get local thread " + threadLocal.get());

            Thread innerThread = new Thread(() -> System.out.println("Inherited thread local value inside thread: " + inheritedThreadLocal.get()));
            innerThread.start();
        });

        Thread thread1 = new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("thread1 get local thread: " + threadLocal.get());
            System.out.println("Inherited thread local value inside thread1: " + inheritedThreadLocal.get());
        });

        thread.start();
        thread1.start();
    }
}
