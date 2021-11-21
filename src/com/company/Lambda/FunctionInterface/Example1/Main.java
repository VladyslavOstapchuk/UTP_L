package com.company.Lambda.FunctionInterface.Example1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FuncInterface<Integer> func = (n) -> { return n * n; };
//        System.out.println(func.foo(12));

        Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] strings = {"Ala", "ma","kota"};

        Processor <Integer> integerProcessor = (n) -> {return n+1;};
        Processor <String> stringProcessor = (n) -> {return n.toUpperCase();};

        arrOp(strings,stringProcessor);
        arrOp(ints,integerProcessor);

        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(strings));

        arrOp(strings,(n)->{ return n.toLowerCase();});
        arrOp(ints,(n)->{ return n-1;});

        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(strings));
    }

    public static <T> void  arrOp (T [] arr, Processor<T> processor) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (T) processor.process(arr[i]);
        }
    }
}