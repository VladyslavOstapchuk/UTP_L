package com.company.Lambda.ExceptionsInInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Main {
    //return transformed collection
    static <S, T> List transform(Collection<S> src, Function<S, T> function) throws Exception {
        //tmp list will contain result of Function<S,T> method apply
        List<T> target = new ArrayList<>();
        for (S s : src) target.add(function.apply(s));

        return target;
    }

    //return the same arg after 1 sec
    static <T> T sameAfterSec(T arg) throws InterruptedException {
        //interrupt program for 1 sec
        Thread.sleep(1000);
        //return arg
        return arg;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                transform(Arrays.asList(1, 2, 3), // List {1,2,3}
                        (CEF<Integer, Integer>) // to force system use our new interface method apply not method of interface java.util.Function
                                n -> n == 2 ? sameAfterSec(n) : n + 1) // lambda realization of method apply
        );
    }
}
