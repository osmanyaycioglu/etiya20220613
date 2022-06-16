package com.training.lambdas.java;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class JavaInterfacesRun {
    public static void main(String[] args) {
        String denemeStr = "1";
        List<String> stringList = List.of("osman",
                                          "mehmet",
                                          "ali",
                                          "ahemd");
        Consumer<String> consumer = s -> System.out.println(s);
        BiConsumer<String,String> biConsumer = (s1,s2) -> System.out.println(s1 + " " + s2);
        IntConsumer primConsumer = e -> System.out.println("gelen " + e);

        stringList.forEach(consumer.andThen(s -> System.out.println("xyz " + s))
                                   .andThen(s -> System.out.println("abc " + s)));
        // stringList.forEach(System.out::println);
        Function<String, String> function1 = d -> "prefix : " + d;
        Function<Integer, String> function2 = d -> "sonuç : " + (d + 100);
        Function<String, Integer> function3 = r -> Integer.parseInt(r);
        BiFunction<String,String,Integer> biFunction = (f,g) -> Integer.parseInt(f+g);
        UnaryOperator<String> function4 = d -> "prefix : " + d;
        BinaryOperator<String> biFunctionAllSame = (s1,s2) -> s1 + " " + s2;
        BiFunction<String,String,String> biFunctionAllSame2 = (s1,s2) -> s1 + " " + s2;

        Predicate<String> predicate1 = w -> w.length() > 5;
        if (predicate1.test("osmana")) {
            System.out.println("Girdi");
        }
        BiPredicate<String,Integer> biPredicate = (s,i) -> s.length() == i;

        Supplier<String> supplier = () -> "hello";
        if (test1) {
            xyz(stringList.get(0) + " eklenti " + denemeStr);
        }
        xyz(() -> stringList.get(0) + " eklenti " + denemeStr);

        Comparator<String> compareStr = String::compareTo;
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
