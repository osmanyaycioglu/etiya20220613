package com.training.enums;

import com.training.oo.interfaces.IHello;

public enum EHello implements IHello {
    ENGLISH,
    TURKISH {
        @Override
        public String sayHello(String name) {
            return "Selam " + name;
        }

        @Override
        public String getDesc() {
            return "Turkish";
        }

    },
    SPANISH {
        @Override
        public String sayHello(String name) {
            return "Ola " + name;
        }

        @Override
        public String getDesc() {
            return "Spanish";
        }

    };

    @Override
    public Object cloneMe() {
        return null;
    }

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String getDesc() {
        return "English";
    }

}
