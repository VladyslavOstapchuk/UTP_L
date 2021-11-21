package com.company.Lambda.Example2;

public class Animal {
    String type;

    public Animal(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type +
                '}';
    }
}
