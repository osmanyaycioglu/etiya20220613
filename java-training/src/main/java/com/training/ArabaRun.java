package com.training;

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
        }
    }
}
