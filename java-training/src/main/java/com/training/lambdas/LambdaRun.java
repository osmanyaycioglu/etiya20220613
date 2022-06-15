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

        ITest iTest3 = new ITest() {
            @Override
            public String testMe(String str) {
                return strx + " tested with anonymous class impl " + str;
            }
        };

        System.out.println(iTest2.testMe("osman"));
        ITest lambda1 = z -> strx + " tested with lambda class impl " + z;
        System.out.println(lambda1.testMe("osman"));
        System.out.println(lambda1.newMethod("osman"));

        ITest lamda2 = quickTest -> strx + " tested with lambda class impl " + quickTest;

        ITest lamda3 = q -> {
            ITest.myStaticMethod(q);
            return strx + " tested with lambda class impl " + q;
        };

        IWrite write1 = (s1,s2) -> "Concat " + s1 + " " + s2;
        IWrite write2 = (s1,s2) -> {
            System.out.println("test");
            return "Concat " + s1 + " " + s2;
        };
        IWrite write3 = LambdaRun::xyz;
        LambdaRun l = new LambdaRun();
        IWrite write4 = l::abc;
        System.out.println("----------------------------------------------");
        System.out.println(write1.writeMe("osman","yaycıoğlu"));
        System.out.println(write2.writeMe("osman","yaycıoğlu"));
        System.out.println(write3.writeMe("osman","yaycıoğlu"));
        System.out.println(write4.writeMe("osman","yaycıoğlu"));
        IRead iRead = () -> "Read test";
    }

    public static String xyz(String s1,String s2){
        return "xyz left : " + s1 + " Right : " + s2;
    }

    public String abc(String s1,String s2){
        return "abc left : " + s1 + " Right : " + s2;
    }

}
