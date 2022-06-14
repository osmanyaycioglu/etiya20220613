package com.training;

public class PersonRun {
    public static void main(String[] args) {
//        Person person = new Person("osman",
//                                   "yaycıoğlu",
//                                   95,
//                                   200);
        Person person = Person.builder()
                              .withName("osman")
                              .withSurname("yaycıoğlu")
                              .withHeight(200)
                              .withWeight(95)
                              .build();

        Araba araba = Araba.create()
                           .setName("my araba")
                           .setBrand("opel")
                           .setHorsePower(100)
                           .setSpeed(180);

        String string = "osman";
        string += " yaycıoğlu";
        string = string.concat(" 100");
        System.out.println(string);

        String name  = new String("osman");
        if (name == "osman") {
            System.out.println("eşit");
        }
        StringBuilder stringBuilder = new StringBuilder(3_000_000);
        try {
            Thread.sleep(2_000);
            System.gc();
            Thread.sleep(3_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String deneme = "deneme";
        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringBuilder.append("ek");
            stringBuilder.append(i);
            // deneme += "ek" + i;
        }
        System.out.println("Delta : " + (System.currentTimeMillis() - delta));

        String str1 = "osman" + araba + " yaycı" + person;
        String str2 = "osman" + araba;
        str2 += " yaycı" + person;
    }
}
