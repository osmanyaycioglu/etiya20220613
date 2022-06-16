package com.training.streams;

import com.training.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRun3 {
    public static void main(String[] args) {
        List<String> stringList = List.of("osman",
                                          "mehmet",
                                          "ali",
                                          "veli",
                                          "ayşe",
                                          "fatma",
                                          "osman",
                                          "mehmet");

        List<Character> collect = stringList.stream()
                                            .peek(s -> System.out.println("Before Flat map : " + s))
                                            .flatMap(s -> {
                                                Character[] characters = new Character[s.length()];
                                                for (int i = 0; i < s.length(); i++) {
                                                    characters[i] = s.charAt(i);
                                                }
                                                return Arrays.stream(characters);
                                            })
                                            .peek(c -> System.out.println("After Flat map : " + c))
                                            .distinct()
                                            .sorted()
                                            .collect(Collectors.toList());
        System.out.println(collect);

        Stream<Stream<Character>> streamStream = stringList.stream()
                                                           .peek(s -> System.out.println("Before Flat map : " + s))
                                                           .map(s -> {
                                                               Character[] characters = new Character[s.length()];
                                                               for (int i = 0; i < s.length(); i++) {
                                                                   characters[i] = s.charAt(i);
                                                               }
                                                               return Arrays.stream(characters);
                                                           });
        Stream<Character> characterStream = stringList.stream()
                                                      .peek(s -> System.out.println("Before Flat map : " + s))
                                                      .flatMap(s -> {
                                                          Character[] characters = new Character[s.length()];
                                                          for (int i = 0; i < s.length(); i++) {
                                                              characters[i] = s.charAt(i);
                                                          }
                                                          return Arrays.stream(characters);
                                                      });
    }

}
