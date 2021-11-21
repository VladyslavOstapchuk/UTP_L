package com.company.Lambda.FunctionInterface.Example2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //1
        String name = "Fuck";
        MyInterface myInterface = (var) -> {return var; };
        System.out.println(myInterface.methodName(name));
        //2
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Processor<Integer> processor = n -> {return n*10;};
        //The same
        System.out.println(Arrays.toString(arr));
        changeArray(arr, (n) -> (int) n * 10);
        System.out.println(Arrays.toString(arr));
        changeArray(arr, n -> (int) n * 10);
        System.out.println(Arrays.toString(arr));
    }

    static <T> void changeArray(T[] arr, Processor processor) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (T) processor.process(arr[i]);
        }
    }
}
