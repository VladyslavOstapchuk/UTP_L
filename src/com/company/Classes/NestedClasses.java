package com.company.Classes;

public class NestedClasses {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++)
            new Outer.Inner().fun();
    }
}

class Outer {
    //Nested class must be static to created independent from Outer class
    static class Inner {
        void fun() {
            System.out.println("fun from inner class");
        }
    }
}