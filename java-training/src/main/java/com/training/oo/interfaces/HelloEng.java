package com.training.oo.interfaces;

import java.io.Closeable;
import java.io.IOException;

public class HelloEng implements IHello, Closeable{

    @Override
    public String sayHello(String name) {
        return "Hello : " + name;
    }

    @Override
    public String getDesc() {
        return "English hello";
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
