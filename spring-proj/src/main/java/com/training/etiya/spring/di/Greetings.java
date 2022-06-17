package com.training.etiya.spring.di;

import com.training.etiya.spring.di.HelloEng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Greetings {

    private IHello hello;

    @Autowired
    public Greetings(@Qualifier("helloCreator")  IHello hello) {
        this.hello = hello;
    }

    public void sayHello(String name){
        System.out.println(hello.sayHello(name));
    }

}
