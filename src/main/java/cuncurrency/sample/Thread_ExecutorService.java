package cuncurrency.sample;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Thread_ExecutorService {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter counter = new Counter();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incCounter();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incCounter();
            }
        });

        thread.start();
        thread2.start();
        thread2.join();
        thread.join();

        System.out.print(counter.getCounter());


        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<String> first = service.submit(callable("first"));
        Future<String> second = service.submit(callable("second"));
        Future<String> third = service.submit(callable("third"));

        System.out.println(first.isDone());
        System.out.println(second.isDone());
        System.out.println(third.isDone());
        System.out.println(first.get());
        System.out.println(second.get());
        System.out.println(third.get());

        service.shutdown();
    }

    private static Callable<String> callable(String msg) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "FROM CALLABLE " + msg;
            }
        };
    }
}


class Counter {
    private int counter;
    private final Lock lock = new ReentrantLock();

    public void incCounter() {
        lock.lock();
        try {
            this.counter++;
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        return this.counter;
    }
}


class sampleFunctionalInterfaceUsage {

    public static void main(String[] args) {
        MyFunctionalInterface anInterface = (name) -> System.out.println(name);
        anInterface.printMSG("sample");
        sth(s -> anInterface.printMSG(s));
        sth2(() -> "toSupplier");
    }

    private static void sth(Consumer<String> sampleConsumer) {
        sampleConsumer.accept("SamPLE FROM CONSUMER");
    }

    private static void sth2(Supplier<String> sampleSupplier) {
        String s = sampleSupplier.get();
        System.out.println(s + " from Supplier");
    }
}

@FunctionalInterface
interface MyFunctionalInterface {
    void printMSG(String name);
}


class ShutDownSample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("FROM COMPLETABLE_FUTURE");
            return 1;
        }, executorService).handle((unused, throwable) -> {
            System.out.println("FROM HANDLER "+ unused);
            return 0;
        });
        Integer join = future.join();
        System.out.println(join);

        System.out.println("starting");
//        Future<Integer> submit = executorService.submit(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException ignore) {
//                }
//                return 10;
//            }
//        });

//        Object o = submit.get();
//        System.out.println(o);

        System.out.println("Main thread done executing");
        executorService.shutdown();
    }
}


class SingletonSample {
    private static final SingletonSample instance = new SingletonSample();

    private SingletonSample() {
    }

    public static synchronized SingletonSample getInstance() {
        return instance;
    }

}