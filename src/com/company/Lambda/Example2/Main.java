package com.company.Lambda.Example2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static <T, S> List<T> create(List<S> src, Transformer<T, S> t) {
        List<T> target = new ArrayList<>();
        for (S s : src) target.add(t.transform(s));
        return target;
    }

    static <R, T, S> List<R> create(List<T> src, List<S> src2, Operator<R, T, S> o) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < src.size(); i++) {
            result.add(o.oper(src.get(i),src2.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> s = Arrays.asList("pies","kot","ryba");
        List<String> sn = Arrays.asList("111","222");

        //The same
        //result of work of the first method
        List out1 = create(s,e -> e.toUpperCase());
        out1 = create(s, String::toUpperCase);
        System.out.println(out1);

        String text = "pies i kot sa w domu, a ryba plywa";
        List out2 = create(s, e->text.indexOf(e));
        out2 = create(s,text::indexOf);
        System.out.println(out2);

        List out3 = create(sn, e -> Integer.parseInt(e));
        out3 = create(sn, Integer::parseInt);
        System.out.println(out1);

        List out4 = create(s, e-> new Animal(e));
        out4 = create(s,Animal::new);
        System.out.println(out4);

        List<String> word = Arrays.asList("alabama", "kociokwik");
        List<Integer> pos = Arrays.asList(1,5);
        List out5 = create(word, pos, (e1,e2)->e1.substring(e2));
        out5 = create(word,pos,String::substring);
        System.out.println(out5);

        Transformer <String,String> transformer = String::toUpperCase;
        Operator<String,String,Integer> operator = String::substring;


    }
}
