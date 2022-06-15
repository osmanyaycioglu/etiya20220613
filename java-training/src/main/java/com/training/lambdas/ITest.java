package com.training.lambdas;

@FunctionalInterface
public interface ITest {

    public static final String str = "osman";
    public static String st = "osman2";

    String testMe(String str);

    default String newMethod(String str) {
        String s = testMe(str);
        return "proxy " + s;
    }

    default String newMethod2(String str) {
        String s = testMe(str);
        return "proxy 2 " + s;
    }

    public static String myStaticMethod(String str){
        return "static " + str;
    }

}
