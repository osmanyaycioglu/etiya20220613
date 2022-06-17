package com.training.etiya.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class HelloConf {

//    @Autowired
//    private Environment environment;

//    @Autowired
//    IHello[] helloImpls;

    @Bean
    public IHello helloCreator(Environment environment,@Value("${app.str}") String str,@Value("${app.language}") String lang){
        switch (lang){
            case "tr":
                return new HelloTr(environment,"dene");
            default:
            case "eng":
                return new HelloEng();
        }
    }

    @Bean
    public Greetings greetingsBean1(){
        return new Greetings(new HelloEng());
    }

    @Bean
    public Greetings greetingsBean2(){
        return new Greetings(new HelloEng());
    }

    @Bean
    public Greetings greetingsBean3(){
        return new Greetings(new HelloEng());
    }

    @Bean
    public String xyzStr(){
        return "test";
    }

}
