package com.training.etiya.spring;

import com.training.etiya.spring.di.Greetings;
import com.training.etiya.spring.di.HelloEng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class SpringProjApplication implements ApplicationRunner {

    @Autowired
    private HelloEng helloEng;

    @Autowired
    private Greetings greetings;

    private HelloEng helloEng2;
    @Autowired
    private HelloEng helloEng3;
    @Autowired
    private HelloEng helloEng4;

    @PostConstruct
    public void init(){
        helloEng.xyz();
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroyed");
    }

    @Autowired
    public void hello(HelloEng helloEngParam){
        helloEng2 = helloEngParam;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Before ready");
        System.out.println(helloEng.sayHello("osman"));
        System.out.println(helloEng2.sayHello("osman"));
        System.out.println(helloEng3.sayHello("osman"));
        System.out.println(helloEng4.sayHello("osman"));
//        HelloEng helloEng = new HelloEng();
//        System.out.println(helloEng.sayHello("osman"));
        greetings.sayHello("mehmet");
    }
}
