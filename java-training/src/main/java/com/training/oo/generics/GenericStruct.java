package com.training.oo.generics;

import com.training.oo.configurations.AppConfig;
import com.training.oo.interfaces.ICloneable;
import com.training.oo.interfaces.IHello;

public class GenericStruct<T extends AppConfig & IExecute & IHello & ICloneable> {

    private T t ;


    public String execute(){
        return t.process();
    }


}
