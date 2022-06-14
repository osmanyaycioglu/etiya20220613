package com.training.enums;

public enum ESingleton {
    INSTANCE;

    ESingleton() {
        System.out.println("ESingleton yaratıldı");
    }

    public String test(String name) {
        return "test " + name;
    }
}
