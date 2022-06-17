package com.training.etiya.spring.di;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.training.etiya.spring.aop.SecureMe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class HelloEng implements IHello {

    private int counter = 0;

    public void xyz(){

    }

    @SecureMe("osman")
    public String sayHello(String name) {
        counter++;
        return "Hello " + counter + " " + name;
    }
}
