package com.company.Lambda.Example1;

import java.util.function.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static <T, S> List<T> create(List<S> src, Predicate<S> pred, Function<S, T> func) {
        List<T> target = new ArrayList<>();

        for (S e : src) {
            if (pred.test(e)) {
                target.add(func.apply(e));
            }
        }

        return target;
    }

    //With created interface Modifier
    static <S> void change1(List<S> list, Filter<S> filter, Modifier<S> modifier) {
        for (S e : list) {
            if (filter.test(e)) {
                modifier.modify(e);
            }
        }
    }

    static <S> void change2(List<S> list, Filter<S> filter, Consumer<S> consumer) {
        for (S e : list) {
            if (filter.test(e)) {
                consumer.accept(e);
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> src = Arrays.asList(5, 72, 10, 11, 9);
        List<Integer> target1 = new ArrayList<>();

        for (Integer n : src) {
            if (n < 10) {
                target1.add(n * n);
            }
        }

        //function style:
        //List<type> target = create (
        //src,
        //case,
        //operation)

        System.out.println(create(src, n -> n % 2 != 0, n -> n));

        change1(src, n -> n == 5, n -> n = (n + 10));
        for (Integer n : src) System.out.println(n);
    }
}
