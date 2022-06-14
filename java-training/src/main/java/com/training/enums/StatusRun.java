package com.training.enums;

import com.training.oo.interfaces.IHello;


public class StatusRun {

    public static void main(String[] args) {
        EStatus status = EStatus.SUPENDED;

        String name = status.name();
        int ordinal = status.ordinal();

        EStatus eStatus1 = EStatus.values()[ordinal];
        EStatus eStatus2 = EStatus.valueOf("SUPENDED");

        switch (status) {
            case STOPPED:
                break;
            case SUPENDED:
                break;
            case RUNNING:
                break;
        }
        System.out.println(status.getLongDescription());

        IHello hello = EHello.TURKISH;
        System.out.println(hello.sayHello("osman"));
        System.out.println(ESingleton.INSTANCE.test("osman"));
    }
}
