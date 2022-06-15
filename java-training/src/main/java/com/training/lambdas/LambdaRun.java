package com.training.lambdas;

public class LambdaRun {
    public static void main(String[] args) {
        String strx = "scope test";
        ITest iTest = new TestImpl();
        System.out.println(iTest.testMe("osman"));

        ITest iTest2 = new ITest() {
            @Override
            public String testMe(String str) {
                return strx + " tested with anonymous class impl " + str;
            }
        };
        System.out.println(iTest2.testMe("osman"));
        ITest lambda1 = z -> strx + " tested with lambda class impl " + z;
        System.out.println(lambda1.testMe("osman"));
    }

}
