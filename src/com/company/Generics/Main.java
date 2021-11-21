package com.company.Generics;

public class Main {
    public static void main(String[] args) {
        //With type control
        System.out.println("\nGENERIC TYPE:");
        System.out.println(new SimpleGenericClass<String>("Hello"));
        System.out.println(new SimpleGenericClass<Integer>(2));
        System.out.println(new SimpleGenericClass<Double>(2.2));

        //No type control
        System.out.println("\nOBJECT TYPE:");
        System.out.println(new SimpleObjectClass("Hello"));
        System.out.println(new SimpleObjectClass(2));
        System.out.println(new SimpleObjectClass(2.2));
    }
}
