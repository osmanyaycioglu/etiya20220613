package com.training.etiya.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class HelloTr implements IHello {

    private int counter;
    private Environment environment;

//    public HelloTr(Environment environment,@Value("${app.str}") String str) {
//        this.environment = environment;
//    }

    public HelloTr(Environment environment,@Qualifier("xyzStr") String str) {
        this.environment = environment;
    }

    public String sayHello(String name) {
        counter++;
        return "Merhaba " + counter + " " + name;
    }
}
