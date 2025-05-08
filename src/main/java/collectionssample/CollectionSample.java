package collectionssample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

public class CollectionSample {

    public static void main(String[] args) {
        List<String> list = new ArrayList();

        list.add("a");
        list.add("b");
        list.add("c");

        list.add(0, "aa");
//        System.out.println(list.contains("a"));
        System.out.println(list.indexOf("c"));
        System.out.println(list.size());
        list.remove("b");
        System.out.println(list.indexOf("c"));
        System.out.println("_________________________");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        Collections.reverse(list);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("_________________________");

        Set<String> set = Set.of("a", "b", "c");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        map.keySet().stream()
                .forEach(key -> System.out.println(map.get(key)));

        Queue<String> queue = new LinkedList<>();

        SortedSet<String> set1 = new TreeSet<String>(new MyComparator());
    }
}


class Model implements Comparable<Model> {

    private int id;
    private String name;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((int1, int2) -> {
        return Integer.compare(int1, int2);
    });


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Model)) return false;
        Model m = (Model) obj;
        return m.id == id;
    }

    @Override
    public int compareTo(@NotNull Model o) {
        if (id > o.id) return 1;
        return Integer.compare(id, o.id);
    }
}


class FunctionalProgramming {
    public static void main(String[] args) {
        myInterface print = (value) -> System.out.println(value);
        print.printName("print");

        Function<Integer, String> getText = (val) -> {
            return "passed value is " + val;
        };
        System.out.println(getText.apply(10));

        Predicate<Integer> greaterThan10 = (val) -> val > 10;
        System.out.println(greaterThan10.test(12));

        Function<Integer, Integer> add10 = (val) -> val + 10;
        Function<Integer, Integer> multiply10 = (val) -> val * 10;
        Function<Integer, Integer> addAndThenMulti = add10.andThen(multiply10);
        Function<Integer, Void> printInteger = (Int) -> {
            System.out.println(Int);
            return null;
        };

        BiFunction<Integer, Integer, Integer> addTowInteger = (Int, val) -> val + Int;

        mySupplierTest(() -> addAndThenMulti.apply(10), printInteger::apply, addTowInteger::apply);
    }

    private static void mySupplierTest(Supplier<Integer> getAddition, Consumer<Integer> print, BiFunction<Integer, Integer, Integer> biFunction) {
        Integer i = getAddition.get();
        print.accept(biFunction.apply(i, i));
        print.accept(i);
    }
}

@FunctionalInterface
interface myInterface {
    void printName(String name);
}


class StreamAPISample {

    public static void main(String[] args) {
        Predicate<Integer> isEven = (integer) -> integer % 2 == 0;
        Predicate<Integer> isOdd = (integer) -> integer % 2 != 0;
        Function<Integer, Integer> add10 = integer -> integer + 10;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> sentences = new ArrayList<>();
        sentences.add("Hello World");
        sentences.add("Hello World");
        sentences.add("Good Bye");

        List<String> words = sentences.stream().distinct().flatMap(s -> {
            String[] s1 = s.split(" ");
            return Arrays.stream(s1);
        }).toList();

        Optional<Integer> reduce = list.stream().reduce((value, result) -> value + result);
        System.out.println(reduce.get());

        list = list.stream()
                .filter(isEven)
                .limit(2)
                .map(add10)
                .collect(Collectors.toList());


        boolean b = list.stream().anyMatch(isOdd);
        for (String s : words) {
            System.out.println(s);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}