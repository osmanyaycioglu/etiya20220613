package com.training.oo.generics.lab;

public class PairProcessLeftImpl implements IPairProcess<String,Integer> {
    @Override
    public void processPair(Pair<String, Integer> pair) {
        System.out.println("sonuç : " + (pair.getRight() -Integer.parseInt(pair.getLeft())));
    }
}
