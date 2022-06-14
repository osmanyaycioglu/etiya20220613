package com.training.oo.reflections;

import com.training.Araba;
import com.training.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionRun {
    public static void main(String[] args) {
        Object instance  = Person.builder()
                                 .withName("osman")
                                 .withSurname("yaycıoğlu")
                                 .withHeight(200)
                                 .withWeight(95)
                                 .build();

        Class<?> aClass = instance.getClass();
        Field[] declaredFields1 = aClass.getDeclaredFields();
        for (Field f : declaredFields1) {
            try {
                f.setAccessible(true);
                if (f.getName().equals("height")){
                    f.setInt(instance,300);
                }
                Object o = f.get(instance);
                System.out.println(f.getName() + " = " + o);

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Instance : " + instance);
        Class<Araba> arabaClass = Araba.class;
        try {
            Class<?> aClass1 = Class.forName("com.training.Araba");
        } catch (ClassNotFoundException e) {
        }
        Field[] declaredFields = arabaClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f.getName() + " " + f.getType());
            Annotation[] annotations = f.getAnnotations();
            for (Annotation anno : annotations) {
                System.out.println(f.getName() + " üstünde " + anno.toString() );
            }
        }
        Constructor<?>[] declaredConstructors = arabaClass.getDeclaredConstructors();
        Method[] declaredMethods = arabaClass.getDeclaredMethods();
        try {
            Constructor<Araba> constructor = arabaClass.getConstructor();
            Araba araba = constructor.newInstance();
            System.out.println("Araba  : " + araba);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
