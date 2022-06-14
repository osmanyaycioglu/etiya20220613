package com.training.oo.generics;

import com.training.oo.configurations.AppConfig;

public class GenericRun {
    public static void main(String[] args) {
        GenericStruct<ExecuteImpl> genericStruct = new GenericStruct<>();

        Class<?> appConfigClass = AppConfig.class;

        TripleHolder<String,Integer,Long,Double> tripleHolder = new TripleHolder<>();
        Double calculate = tripleHolder.calculate(100.5D);
        System.out.println("Value : " + calculate);

        Double aDouble = tripleHolder.calculate2(Double.class);
        System.out.println("D Value : " + aDouble);

        IntegerHolder integerHolder = new IntegerHolder();
        integerHolder.setValue(100);
        Integer value = integerHolder.getValue();

        StringHolder stringHolder = new StringHolder();
        stringHolder.setValue("deneme");
        String holderValue = stringHolder.getValue();

        ObjectHolder objectHolder = new ObjectHolder();
        objectHolder.setValue("deneme");
        objectHolder.setValue(100);
        objectHolder.setValue(100L);
        Long s = (Long) objectHolder.getValue();
        System.out.println("Value : " + s);

        GenericHolder<String> genericHolder = new GenericHolder<>();
        genericHolder.setValue("deneme");
        String value1 = genericHolder.getValue();

        GenericHolder<Integer> genericHolder2 = new GenericHolder<>();
        genericHolder2.setValue(100);
        Integer value2 = genericHolder2.getValue();

        GenericHolder<?> genericHolder3 = new GenericHolder<Integer>();
        Integer value3 = (Integer) genericHolder3.getValue();


    }
}
