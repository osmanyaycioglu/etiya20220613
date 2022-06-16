package com.training.streams;

import com.training.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRun {
    public static void main(String[] args) {
        List<String> stringList = List.of("osman",
                                          "mehmet",
                                          "ali",
                                          "veli",
                                          "ayşe",
                                          "fatma",
                                          "osman",
                                          "mehmet");

        stringList.stream()
                  .distinct()
                  .peek(s -> System.out.println("After Distinct : " + s + " thread : " + Thread.currentThread()
                                                                                               .getName()))
                  .filter(s -> s.length() >= 5 && s.contains("a"))
                  .peek(s -> System.out.println("After Filter : " + s + " thread : " + Thread.currentThread()
                                                                                             .getName()))
                  .sorted()
                  .forEach(System.out::println);

        List<Person> personList = stringList.stream()
                                            .skip(1)
                                            .limit(8)
                                            .map(s -> Person.builder()
                                                            .withName(s)
                                                            .build())
                                            .filter(p -> p.getName()
                                                          .length() >= 5)
                                            .collect(Collectors.toList());

        Map<String, Person> stringPersonMap = stringList.stream()
                                                        .skip(1)
                                                        .limit(8)
                                                        .distinct()
                                                        .map(s -> Person.builder()
                                                                        .withName(s)
                                                                        .build())
                                                        .filter(p -> p.getName()
                                                                      .length() >= 5)
                                                        .collect(Collectors.toMap(Person::getName,
                                                                                  p -> p));

        IntSummaryStatistics collect = stringList.stream()
                                                 .skip(1)
                                                 .limit(8)
                                                 .map(s -> Person.builder()
                                                                 .withName(s)
                                                                 .build())
                                                 .filter(p -> p.getName()
                                                               .length() >= 5)
                                                 .collect(Collectors.summarizingInt(p -> p.getName()
                                                                                          .length()));

        IntSummaryStatistics intSummaryStatistics = stringList.stream()
                                                              .skip(1)
                                                              .limit(8)
                                                              .map(s -> Person.builder()
                                                                              .withName(s)
                                                                              .build())
                                                              .filter(p -> p.getName()
                                                                            .length() >= 5)
                                                              .mapToInt(p -> p.getName()
                                                                              .length())
                                                              .summaryStatistics();

        System.out.println("collect : " + collect);
//        Set<String> stringSet = new HashSet<>(stringList);
//        List<String> result = new ArrayList<>();
//        for (String str : stringSet) {
//            if (str.length() >= 5 && str.contains("a")) {
//                result.add(str);
//            }
//        }
//        Collections.sort(result);
//        for (String str : result) {
//            System.out.println(str);
//        }

    }

}
