package com.training.etiya.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Araba {
    @Id
    @GeneratedValue
    private Long arabaId;
    private String name;
    private String brand;
    private Integer horsePower;
    private Integer speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Long getArabaId() {
        return arabaId;
    }

    public void setArabaId(Long arabaId) {
        this.arabaId = arabaId;
    }

    @Override
    public String toString() {
        return "Araba{" +
                "arabaId=" + arabaId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", horsePower=" + horsePower +
                ", speed=" + speed +
                '}';
    }
}
