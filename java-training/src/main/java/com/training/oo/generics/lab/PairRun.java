package com.training.oo.generics.lab;

public class PairRun {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("1340",
                                                 2300,
                                                 new PairProcessLeftImpl());
        Pair<Long, Integer> pair2 = new Pair<>(2000L,
                                                 2300,
                                                 new PairProcessRightImpl());

        pair1.process();
        pair2.process();
    }
}
