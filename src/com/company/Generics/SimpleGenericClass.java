package com.company.Generics;

public class SimpleGenericClass <T>{
    private T var;

    public SimpleGenericClass(T var){
        this.var = var;
    }

    @Override
    public String toString() {
        return "Object of " + this.getClass() + ", value " + var;
    }
}
