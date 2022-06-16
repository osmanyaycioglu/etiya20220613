package com.training.streams;

import com.training.Person;

import java.util.*;
import java.util.stream.Collectors;

public class StreamRun2 {
    public static void main(String[] args) {
        List<String> stringList = List.of("osman",
                                          "mehmet",
                                          "ali",
                                          "veli",
                                          "ayşe",
                                          "fatma",
                                          "osman",
                                          "mehmet");

        Integer reduce = stringList.stream()
                                   .map(s -> Person.builder()
                                                   .withName(s)
                                                   .build())
                                   .filter(p -> p.getName()
                                                 .length() >= 5)
                                   .reduce(0,
                                           (i, p) -> i + p.getName()
                                                          .length(),
                                           Integer::sum);

        ArrayList<Person> reduce1 = stringList.stream()
                                              .map(s -> Person.builder()
                                                              .withName(s)
                                                              .build())
                                              .filter(p -> p.getName()
                                                            .length() >= 5)
                                              .reduce(new ArrayList<Person>(),
                                                      (l, p) -> {
                                                          l.add(p);
                                                          return l;
                                                      },
                                                      (l1, l2) -> {
                                                          l1.addAll(l2);
                                                          return l1;
                                                      });

        ArrayList<Person> reduce2 = stringList.stream()
                                              .map(s -> Person.builder()
                                                              .withName(s)
                                                              .build())
                                              .filter(p -> p.getName()
                                                            .length() >= 5)
                                              .collect(ArrayList::new,
                                                       ArrayList::add,
                                                       ArrayList::addAll
                                              );

        Optional<Person> any = stringList.stream()
                                         .map(s -> Person.builder()
                                                         .withName(s)
                                                         .build())
                                         .filter(p -> p.getName()
                                                       .length() >= 5)
                                         .findAny();

        Optional<Person> first = stringList.stream()
                                           .map(s -> Person.builder()
                                                           .withName(s)
                                                           .build())
                                           .filter(p -> p.getName()
                                                         .length() >= 5)
                                           .findFirst();

        boolean b = stringList.stream()
                              .map(s -> Person.builder()
                                              .withName(s)
                                              .build())
                              .filter(p -> p.getName()
                                            .length() >= 5)
                              .anyMatch(p -> p.getName()
                                              .length() == 6);
        boolean b1 = stringList.stream()
                               .map(s -> Person.builder()
                                               .withName(s)
                                               .build())
                               .filter(p -> p.getName()
                                             .length() >= 5)
                               .allMatch(p -> p.getName()
                                               .length() == 6);

        boolean b2 = stringList.stream()
                               .map(s -> Person.builder()
                                               .withName(s)
                                               .build())
                               .filter(p -> p.getName()
                                             .length() >= 5)
                               .noneMatch(p -> p.getName()
                                                .length() == 6);

    }

}
