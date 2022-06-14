package com.training.oo.interfaces;

public class HelloFactoryEx {

    private static IHello[] hellos = new IHello[]{new HelloEng(), new HelloTr(), new HelloEsp(),new HelloJp()};

    public static IHello createHello(int index) {
        if (index > 0 && index < hellos.length + 1){
            return (IHello) hellos[index - 1].cloneMe();
        }
        return hellos[0];
    }

    public static void printMenu() {
        int index = 1;
        for (IHello hello:hellos) {
            System.out.println(index + "-" + hello.getDesc());
            index++;
        }
    }

}
