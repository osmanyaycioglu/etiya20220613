package com.training;

import java.util.List;

public class ArabaRun {
    public static void main(String[] args) {
        {
            Araba araba = new Araba();
            Araba araba2 = araba;
            int a = 100;
            long b = 1000L;
            Integer c = new Integer(1000);
            Integer d = 100;
        }
        {
            Araba araba = new Araba();
            araba.add("xyz");

            List<String> features = araba.getFeatures();
            features.add("xyz");
            features.clear();
            features.remove(0);

            for (String feature : araba) {
                System.out.println(feature);
            }
        }

    }
}
