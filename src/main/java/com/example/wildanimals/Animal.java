package com.example.wildanimals;

public class Animal {
    protected int id;
    protected String name;
    protected int age;
    protected double weight;

    public Animal(int id, String name, int age, double weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void getInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Weight: " + weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

