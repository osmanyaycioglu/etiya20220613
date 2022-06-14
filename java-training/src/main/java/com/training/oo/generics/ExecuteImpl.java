package com.training.oo.generics;

import com.training.oo.configurations.AppConfig;
import com.training.oo.interfaces.ICloneable;
import com.training.oo.interfaces.IHello;

public class ExecuteImpl extends AppConfig implements IExecute, IHello, ICloneable {

    @Override
    public String process() {
        return "Processed";
    }

    @Override
    public Object cloneMe() {
        return null;
    }

    @Override
    public String sayHello(String name) {
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
