package com.training.oo.interfaces;

import java.util.Scanner;

public class HelloImpl {



    public void run() {
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(System.in);
//            System.out.println("seçiminiz:");
//            int nextInt = scanner.nextInt();
//            System.out.println("Girişiniz : " + nextInt);
//
//        } catch (Exception exp) {
//            exp.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }
        try (Scanner scanner2 = new Scanner(System.in); HelloEng helloEng = new HelloEng();) {
            HelloFactoryEx.printMenu();
            System.out.println("seçiminiz:");
            int nextInt = scanner2.nextInt();
            IHello hello = HelloFactoryEx.createHello(nextInt);
            System.out.println(hello.sayHello("osman"));
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

}
