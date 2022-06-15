package com.training.oo.generics.lab;

public class Pair<T,V> {
    private T left;
    private V right;
    private IPairProcess<T,V> pairProcess;

    public Pair(T left,
                V right,
                IPairProcess<T, V> pairProcess) {
        this.left = left;
        this.right = right;
        this.pairProcess = pairProcess;
    }

    public void leftToRight(){
        System.out.println("Left -> Right " + left + " : " + right );
    }

    public void rightToLeft(){
        System.out.println("right -> Left " + right + " : " + left );
    }

    public void process(){
        pairProcess.processPair(this);
    }

    public T getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public V getRight() {
        return right;
    }

    public void setRight(V right) {
        this.right = right;
    }
}
