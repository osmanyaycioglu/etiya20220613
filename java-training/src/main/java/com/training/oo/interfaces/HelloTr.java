package com.training.oo.interfaces;

public class HelloTr implements IHello {

    @Override
    public String sayHello(String name) {
        return "Selam : " + name;
    }

    @Override
    public String getDesc() {
        return "Turkish hello";
    }

    public String saySomething(){
        return "birşey";
    }

    @Override
    public Object cloneMe() {
        return new HelloTr();
    }
}
