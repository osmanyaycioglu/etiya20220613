package com.training.oo.generics.lab;

public class PairProcessRightImpl implements IPairProcess<Long,Integer> {
    @Override
    public void processPair(Pair<Long, Integer> pair) {
        System.out.println("sonuç : " + (pair.getRight() - pair.getLeft()));
    }
}
