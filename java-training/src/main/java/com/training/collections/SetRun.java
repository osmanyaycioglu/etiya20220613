package com.training.collections;

import com.training.Araba;

import java.util.*;

public class SetRun {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        Set<String> stringSetthreadSafe = Collections.synchronizedSet(new HashSet<>());
        Set<String> stringSetSorted = new TreeSet<>();
        Set<Araba> arabaSetSorted = new TreeSet<>();

        Set<Araba> arabaSet = new HashSet<>();
        stringSet.add("osman");
        stringSet.add("mehmet");
        stringSet.add("ahmet");
        stringSet.add("osman");
        stringSet.add("osman");
        System.out.println(stringSet);

        Set<String> numbersSet1 = new HashSet<>();
        numbersSet1.add("1");
        numbersSet1.add("2");
        numbersSet1.add("3");
        numbersSet1.add("4");
        numbersSet1.add("5");
        numbersSet1.add("6");

        Set<String> numbersSet2 = new HashSet<>();
        numbersSet2.add("4");
        numbersSet2.add("5");
        numbersSet2.add("6");
        numbersSet2.add("7");
        numbersSet2.add("8");
        numbersSet2.add("9");

        Set<String> retainSet = new HashSet<>(numbersSet1);
        retainSet.retainAll(numbersSet2); // Kesişim için
        System.out.println("Kesişim : " + retainSet);

        Set<String> removeSet = new HashSet<>(numbersSet1);
        removeSet.removeAll(numbersSet2);
        System.out.println("Fark : " + removeSet);

        Set<String> addSet = new HashSet<>(numbersSet1);
        addSet.addAll(numbersSet2);
        System.out.println("Birleşim : " + addSet);



        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringSet.add("add" + i);
        }
        System.out.println("Add Delta : " + (System.currentTimeMillis() - delta) );

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            boolean c = stringSet.contains("add" + i);
        }
        System.out.println("Contains Delta : " + (System.currentTimeMillis() - delta) );

        delta = System.currentTimeMillis();
        for (String str : stringSet) {
            String s = str;
        }
        System.out.println("Walk Delta : " + (System.currentTimeMillis() - delta) );

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringSet.remove("add" + i);
        }
        System.out.println("Remove Delta : " + (System.currentTimeMillis() - delta) );

    }
}
