package com.company.Collections.OperationsOnCollections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        ex1();
//    ex2();
    ex3();
    }

    //How to get unmodifiable list
    public static void ex1(){
        List<String> tmp = new ArrayList<>(Arrays.asList("Ala","ma","kota"));
        List<String> list = Collections.unmodifiableList(tmp);

        try {
            list.add("!");
        } catch (UnsupportedOperationException e){
            System.err.println("This list is unmodifiable");
        }
    }

    //All methods of interface Collection
    public static void ex2(){
        List list = new ArrayList();
        //adds element
        list.add(1);
        list.add(3.14);
        list.add("Text");
        //add element at position 0
        list.add(0,"first element");
        //get element at position 0
        System.out.println(list.get(0));
        list.add(1);
        //returns index of first appearing of element
        System.out.println(list.indexOf(1));
        //returns index of last appearing of element
        System.out.println(list.lastIndexOf(1));
        //removes element
        list.remove(list.lastIndexOf(1));
        //returns sublist
        List sublist = list.subList(0,3);
        System.out.println("list " + list);
        System.out.println("sublist " + sublist);
        //sort list by Comparator
        List<Integer> integers = new ArrayList<>(Arrays.asList(3,2,1));
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });
        System.out.println(integers);
        //replace all elements with n
        integers.replaceAll(e-> e*e);
        System.out.println(integers);



    }

    //LinkedList - double linked queue
    //ArrayDeque - double linked queue based on array
    //PriorityQueue - queue with priorities
    public static void ex3(){
        PriorityQueue<String> priorityQueue = new PriorityQueue(Arrays.asList("Ala","ma","kota"));
        String s;
        while((s=priorityQueue.poll()) != null){
            System.out.println(s + " ");
        }
        System.out.println();
    }
}
