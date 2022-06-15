package com.training.collections;

import java.util.ArrayList;
import java.util.List;

public class ListHolder<T> {
    private List<T> tList = new ArrayList<>();

    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }
}
