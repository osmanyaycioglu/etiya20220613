package com.training;

import com.training.oo.annotations.CheckAnno;
import com.training.oo.annotations.MyAnno;

public class Araba {
    @MyAnno(myValue = "osman",intValue = 100)
    private String name;
    @MyAnno(myValue = "osman")
    private String brand;
    @CheckAnno(value = "mehmet",count = 20)
    private Integer horsePower;
    @CheckAnno({"mehmet","osman","ali"})
    private Integer speed;

    public Araba(){
    }

    public static Araba create(){
        return new Araba();
    }

    public void forward(){
        System.out.println("İleri git");
    }

    public void turn(){
        System.out.println("Dön");
    }

    public String getName() {
        return name;
    }

    public Araba setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Araba setBrand( String brand) {
        this.brand = brand;
        return this;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public Araba setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Araba setSpeed(Integer speed) {
        this.speed = speed;
        return this;
    }
}
