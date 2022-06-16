package com.training.streams.lab;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerReadRun {
    public static void main(String[] args) {
        try {
            List<Customer> collect = Files.readAllLines(Paths.get("customer.txt"))
                                          .stream()
                                          .map(s -> s.split(","))
                                          .filter(sa -> sa.length == 6)
                                          .map(sa -> Customer.createCustomer()
                                                             .setName(sa[0])
                                                             .setSurname(sa[1])
                                                             .setUsername(sa[2])
                                                             .setPassword(sa[3])
                                                             .setActive(Boolean.valueOf(sa[4]))
                                                             .setAccountList(Arrays.stream(sa[5].split(";"))
                                                                                   .map(s -> s.split("\\#"))
                                                                                   .map(stra -> new Account(EAccountType.valueOf(stra[0]),
                                                                                                            new BigDecimal(stra[1],
                                                                                                                           MathContext.DECIMAL64)))
                                                                                   .collect(Collectors.toList())))
                                          .filter(Customer::isActive)
                                          .collect(Collectors.toList());
            collect.forEach(System.out::println);
            List<Customer> collect2 = Files.readAllLines(Paths.get("customer.txt"))
                                          .stream()
                                          .map(s -> s.split(","))
                                          .filter(sa -> sa.length == 6)
                                          .map(sa -> Customer.createCustomer()
                                                             .setName(sa[0])
                                                             .setSurname(sa[1])
                                                             .setUsername(sa[2])
                                                             .setPassword(sa[3])
                                                             .setActive(Boolean.valueOf(sa[4]))
                                                             .parseAccounts(sa[5]))
                                          .filter(Customer::isActive)
                                          .collect(Collectors.toList());

//            String[] split1 = "sdfhsdf".split("\\#");
//            Stream<String[]> generate = Stream.generate(() -> "sdfhsdf".split("\\#"));
//
//            Stream<String> stream = Arrays.stream(split1);
//            Stream<String> split = Stream.of("sdfhsdf".split("\\#"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
