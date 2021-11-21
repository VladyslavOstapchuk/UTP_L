package com.company.Lambda.FunctionInterface.Example2;

public interface SAMC {
    //methods in interface are abstract by default
    void doWork(String s);

    //default is used for creating non static methods
    default public void done(){
        System.out.println("Done");
    }
}
