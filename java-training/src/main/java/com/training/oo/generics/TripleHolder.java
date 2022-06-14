package com.training.oo.generics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class TripleHolder<T, V, K, J> {
    private T value1;
    private V value2;
    private K value3;

    public J calculate(J value) {
//        Class<?> aClass = this.getClass();
//        Method[] methods = aClass.getMethods();
//        for (Method method : methods) {
//            if (method.getName().equals("calculate")){
//                Class<?> returnType = method.getReturnType();
//                if (returnType.getName().equals("java.lang.Long")){
//                    return (J) new Long(100);
//                } else if (returnType.getName().equals("java.lang.Double")){
//                    Double retVal = 103.33D;
//                    return (J) retVal;
//                }
//            }
//        }
        if (value instanceof Long) {
            return (J) new Long(100);
        } else if (value instanceof Double) {
            Double retVal = 103.33D;
            return (J) retVal;
        }
        return null;
    }

    public static Class<?> getGenericTypesOfField(final Field field) {
        final Type genericType = field.getGenericType();
        Class<?> clazz = null;
        if (genericType != null) {
            if (genericType instanceof ParameterizedType) {
                final ParameterizedType parameterizedType = (ParameterizedType) genericType;
                final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (actualTypeArguments != null) {
                    if (actualTypeArguments.length > 0) {
                        final Type parameterType = actualTypeArguments[0];
                        if (parameterType instanceof Class) {
                            clazz = (Class<?>) parameterType;
                        }
                    }
                }
            }
        }
        return clazz;
    }


    public J calculate2(Class<J> value) {
        if (value.getName()
                 .equals(Long.class.getName())) {
            return (J) new Long(100);
        } else if (value.getName()
                        .equals(Double.class.getName())) {
            Double retVal = 103.33D;
            return (J) retVal;
        }
        return null;
    }


    public T getValue1() {
        return value1;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public V getValue2() {
        return value2;
    }

    public void setValue2(V value2) {
        this.value2 = value2;
    }

    public K getValue3() {
        return value3;
    }

    public void setValue3(K value3) {
        this.value3 = value3;
    }
}
