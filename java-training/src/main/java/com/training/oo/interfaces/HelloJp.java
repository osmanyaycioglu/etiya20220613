package com.training.oo.interfaces;

import java.io.Closeable;
import java.io.IOException;

public class HelloJp implements IHello, Closeable {

    @Override
    public String sayHello(String name) {
        return "Ahh : " + name;
    }

    @Override
    public String getDesc() {
        return "Japanese hello";
    }

    public String saySomething(){
        return "something";
    }

    @Override
    public void close() throws IOException {
        System.out.println("Closed");
    }

    @Override
    public Object cloneMe() {
        return new HelloJp();
    }
}
