package com.training.oo.interfaces;

public class HelloFactory {
    private static final int ENGLISH_INDEX = 1;
    private static final int TURKISH_INDEX = 2;
    private static final int SPANISH_INDEX = 3;

    public static IHello createHello(int index){
        switch (index) {
            case ENGLISH_INDEX:
                return new HelloEng();
            case TURKISH_INDEX:
                return new HelloTr();
            case SPANISH_INDEX:
                return new HelloEsp();
            default:
                return new HelloEng();
        }
    }

    public static void printMenu(){
        System.out.println(ENGLISH_INDEX + "-English");
        System.out.println(TURKISH_INDEX + "-turkish");
        System.out.println(SPANISH_INDEX + "-spanish");

    }

}
