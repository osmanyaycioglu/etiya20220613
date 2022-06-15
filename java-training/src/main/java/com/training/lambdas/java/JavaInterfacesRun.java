package com.training.lambdas.java;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaInterfacesRun {
    public static void main(String[] args) {
        String denemeStr = "1";
        List<String> stringList = List.of("osman",
                                          "mehmet",
                                          "ali",
                                          "ahemd");
        Consumer<String> consumer = s -> System.out.println(s);
        stringList.forEach(consumer.andThen(s -> System.out.println("xyz " + s))
                                   .andThen(s -> System.out.println("abc " + s)));
        // stringList.forEach(System.out::println);
        Function<String, String> function1 = d -> "prefix : " + d;
        Function<Integer, String> function2 = d -> "sonuç : " + (d + 100);
        Function<String, Integer> function3 = r -> Integer.parseInt(r);

        Predicate<String> predicate1 = w -> w.length() > 5;
        if (predicate1.test("osmana")) {
            System.out.println("Girdi");
        }

        Supplier<String> supplier = () -> "hello";
        if (test1) {
            xyz(stringList.get(0) + " eklenti " + denemeStr);
        }
        xyz(() -> stringList.get(0) + " eklenti " + denemeStr);
    }

    public static boolean test1 = false;

    public static void xyz(String str) {
        if (test1) {
            System.out.println(str);
        }
    }

    public static void xyz(Supplier<String> stringSupplier) {
        if (test1) {
            System.out.println(stringSupplier.get());
        }
    }

}
