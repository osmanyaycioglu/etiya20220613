package com.training.lambdas;

public class TestImpl implements ITest {

    @Override
    public String testMe(String str) {
        return "tested with class impl " + str;
    }
}
