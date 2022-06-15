package com.training.collections;

import com.training.Araba;
import com.training.Person;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapRun {
    public static void main(String[] args) {
        Map<String, Araba> arabaMap = new HashMap<>();
        Map<String, Araba> arabaMapSorted = new TreeMap<>();
        Map<String, Araba> arabaMapThreadSafe = new Hashtable<>();
        Map<String, Araba> arabaMapThreadSafe2 = new ConcurrentHashMap<>(1_000_000,
                                                                         0.9F,
                                                                         1_000);

        Map<String,List<Araba>> arabaListMap = new HashMap<>();
        Map<String,List<Map<String, Person>>> arabaListMapCont = new HashMap<>();
        Map<String,Set<Araba>> arabaSetMap = new HashMap<>();
        Map<String,ListHolder<Araba>> arabaListHolderMap = new HashMap<>();
        Map<String,Map<String,Araba>> arabaMapMap = new HashMap<>();

        arabaMap.put("tosba",
                     new Araba("tosba",
                               "opel",
                               100,
                               180));
        arabaMap.put("kirmizi",
                     new Araba("kirmizi",
                               "bmw",
                               170,
                               230));
        arabaMap.put(null,
                     new Araba("test",
                               "mercedes",
                               170,
                               230));
        System.out.println("Size : " + arabaMap.size());
        Araba araba = arabaMap.get("kirmizi");
        System.out.println(araba);

        Collection<Araba> values = arabaMap.values();
        for (Araba aar : values) {
            System.out.println("1." + aar);
        }
        Set<String> strings = arabaMap.keySet();
        for (String str : strings) {
            System.out.println("2." + arabaMap.get(str));
        }
        Set<Map.Entry<String, Araba>> entries = arabaMap.entrySet();
        for (Map.Entry<String, Araba> entry : entries) {
            System.out.println("3." + entry.getKey() + " : " + entry.getValue());
        }

        Map<String, Integer> map = new HashMap<>();
        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.put("add" + i,
                    i);
        }
        System.out.println("Add Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            Integer integer = map.get("add" + i);
        }
        System.out.println("Get Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (Integer i : map.values()) {
            Integer z = i;
        }
        System.out.println("Walk Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.remove("add" + i);
        }
        System.out.println("Remove Delta : " + (System.currentTimeMillis() - delta));

    }
}
