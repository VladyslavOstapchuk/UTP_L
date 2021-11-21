package com.company.Lambda.ExceptionsInInterfaces;

import java.util.function.Function;

public interface CEF <R,T> extends Function<T,R> {
    R checkedApply(T arg) throws Exception;

    default R apply(T arg){
        try {
            return checkedApply(arg);
        } catch (RuntimeException exc){
            //Use already existing object
            throw exc;
        } catch (Exception exc){
            //Create a new one was caught exception of other different type
            throw new RuntimeException(exc);
        }
    }
}
