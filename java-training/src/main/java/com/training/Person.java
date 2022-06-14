package com.training;

public class Person {
    private final String name;
    private final String surname;
    private final int weight;
    private final int height;

    private Person(String name,
                  String surname,
                  int weight,
                  int height) {
        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }


    public static class PersonBuilder {
        private  String name;
        private  String surname;
        private  int weight;
        private  int height;

        private PersonBuilder() {
        }

        public String getName() {
            return name;
        }

        public PersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public String getSurname() {
            return surname;
        }

        public PersonBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public int getWeight() {
            return weight;
        }

        public PersonBuilder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public int getHeight() {
            return height;
        }

        public PersonBuilder withHeight(int height) {
            this.height = height;
            return this;
        }

        public Person build(){
            return new Person(name,surname,weight,height);
        }
    }
}
