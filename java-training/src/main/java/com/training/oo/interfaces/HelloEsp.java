package com.training.oo.interfaces;

import java.io.Closeable;
import java.io.IOException;

public class HelloEsp implements IHello, Closeable {

    @Override
    public String sayHello(String name) {
        return "Ola : " + name;
    }

    @Override
    public String getDesc() {
        return "Spanish hello";
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
        return new HelloEng();
    }
}
