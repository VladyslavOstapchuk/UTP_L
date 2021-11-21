package com.company.Generics;

public class SimpleObjectClass {
    Object var;

    public SimpleObjectClass(Object var){
        this.var = var;
    }

    @Override
    public String toString() {
        return "Object of " + this.getClass() + ", value " + var;
    }
}
