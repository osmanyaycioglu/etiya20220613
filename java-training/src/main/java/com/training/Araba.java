package com.training;

import com.training.oo.annotations.CheckAnno;
import com.training.oo.annotations.MyAnno;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Araba implements Iterable<String>,Comparable<Araba>{
    @MyAnno(myValue = "osman",intValue = 100)
    private String name;
    @MyAnno(myValue = "osman")
    private String brand;
    @CheckAnno(value = "mehmet",count = 20)
    private Integer horsePower;
    @CheckAnno({"mehmet","osman","ali"})
    private Integer speed;

    private List<String> features = new ArrayList<>();

    public Araba(){
    }

    public Araba(String name,
                 String brand,
                 Integer horsePower,
                 Integer speed) {
        this.name = name;
        this.brand = brand;
        this.horsePower = horsePower;
        this.speed = speed;
    }

    public void add(String feature){
        features.add(feature);
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

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @Override
    public Iterator<String> iterator() {
        return features.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Araba araba = (Araba) o;
        return Objects.equals(name,
                              araba.name) && Objects.equals(brand,
                                                            araba.brand)
                && Objects.equals(horsePower,
                                  araba.horsePower) && Objects.equals(speed,
                                                                      araba.speed)
                && Objects.equals(features,
                                  araba.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                            brand,
                            horsePower,
                            speed,
                            features);
    }

    @Override
    public int compareTo(Araba o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Araba{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", horsePower=" + horsePower +
                ", speed=" + speed +
                ", features=" + features +
                '}';
    }
}
