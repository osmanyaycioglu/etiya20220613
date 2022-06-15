package com.training.collections;

import com.training.Araba;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListRun {
    public static void main(String[] args) {
        List<String> stringList1 = new ArrayList<>(1_100_000);
        List<String> stringList2 = new LinkedList<>();
        List<String> stringList3 = new Vector<>(); // Threadsafe
        List<String> stringList5 = Collections.synchronizedList(new ArrayList<String>()); // Threadsafe
        List<String> stringList4 = new CopyOnWriteArrayList<>();

        List<String> stringList = stringList4;

        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringList.add("add");
        }
        System.out.println("Add Delta : " + (System.currentTimeMillis() - delta) );


        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            String s = stringList.get(i);
        }
        System.out.println("Get Delta : " + (System.currentTimeMillis() - delta) );

        delta = System.currentTimeMillis();
        for (String str : stringList) {
            String s = str;
        }

        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
        }
        System.out.println("Walk Delta : " + (System.currentTimeMillis() - delta) );

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringList.remove(0);
        }
        System.out.println("Remove Delta : " + (System.currentTimeMillis() - delta) );

        boolean contains = stringList.contains("123"); // Büyük listelerde kullanmayın


//        String[] strs = new String[10];
//        String[] strNews = new String[20];
//        System.arraycopy(strs,0,strNews,0,10);

        // strs[10] = "osman";


//        Araba[] arabas = new Araba[10];
//        arabas[0] = new Araba();


    }
}
