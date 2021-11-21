package com.company.Collections.Iterable;

import java.util.*;

public class Spliterators {

    /*Spliterator is iterator allowing separating simple iterator and allowing work on them by several iterators
    trySplit()
    tryAdvance(Consumer c)

    Spliterator<T> spliter = collection.spliterator()
    Consumer consumer = elt -> do_something_with_elt
        while(spliter.tryAdvance(oper)){
        do_something_if_collection_not_exhausted
    }
    do_something_after_collection_processing_end
     */

    //ArrayList is used if access by index is needed
    //Linked list is needed if you need to remove or add elements into middle of Collection

    public static void main(String[] args) {

    }


    public static void ex1() {
        List<Customer> cList = new LinkedList<>(
                Arrays.asList(
                        new Customer("123", 200),
                        new Customer("456", 300),
                        new Customer("789", 400),
                        new Customer("1011", 400))
        );

        System.out.println("Customers before bonus:");
        cList.forEach(System.out::println);

        Spliterator<Customer> spliterator = cList.spliterator();
        //first half of customers gets bonus
        int n = cList.size() / 2;
        int bonus1 = 2000;
        int bonus2 = 1500;
        //for first half of customers
        while (n-- > 0)
            spliterator.tryAdvance(e -> e.setBonus(bonus1));
        //for the remaining half
        spliterator.forEachRemaining(e -> e.setBonus(bonus2));

        System.out.println("Customers after bonus:");
        cList.forEach(System.out::println);


    }

    //divide one list into several parts
    public static void ex2() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        Spliterator<Integer> spliterator0 = list.spliterator();
        //first separation
        Spliterator<Integer> spliterator1 = spliterator0.trySplit();

        show("spliterator0", spliterator0);
        show("spliterator1", spliterator1);

        System.out.println("=================================");
        //refilling spliterator
        spliterator0 = list.spliterator();
        spliterator1 = spliterator0.trySplit();

        Spliterator<Integer> spliterator2 = spliterator0.trySplit();

        show("spliterator0", spliterator0);
        show("spliterator1", spliterator1);
        show("spliterator2", spliterator2);
        System.out.println("=================================");

        spliterator0 = list.spliterator();
        spliterator1 = spliterator0.trySplit();
        spliterator2 = spliterator1.trySplit();
        Spliterator<Integer> spliterator3 = spliterator0.trySplit();

        show("spliterator0", spliterator0);
        show("spliterator1", spliterator1);
        show("spliterator2", spliterator2);
        show("spliterator3", spliterator3);

        System.out.println("=================================");

        spliterator0 = list.spliterator();
        spliterator1 = spliterator0.trySplit();
        spliterator2 = spliterator1.trySplit();
        spliterator3 = spliterator0.trySplit();

        Spliterator<Integer> finalSpliterator0 = spliterator0;
        Spliterator<Integer> finalSpliterator1 = spliterator1;
        Spliterator<Integer> finalSpliterator2 = spliterator2;
        Spliterator<Integer> finalSpliterator3 = spliterator3;

        Thread threads[] = new Thread[]{
                new Thread(() -> {
                    List<Integer> list1 = new LinkedList<>();
                    finalSpliterator0.forEachRemaining(e -> list1.add(e));

                    for (int l : list1) {
                        System.out.println("thread1" +
                                " " +
                                l);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }),
                new Thread(() -> {
                    List<Integer> list1 = new LinkedList<>();
                    finalSpliterator1.forEachRemaining(e -> list1.add(e));

                    for (int l : list1) {
                        System.out.println("thread2" +
                                " " +
                                l);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }),
                new Thread(() -> {
                    List<Integer> list1 = new LinkedList<>();
                    finalSpliterator2.forEachRemaining(e -> list1.add(e));

                    for (int l : list1) {
                        System.out.println("thread3" +
                                " " +
                                l);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }),
                new Thread(() -> {
                    List<Integer> list1 = new LinkedList<>();
                    finalSpliterator3.forEachRemaining(e -> list1.add(e));

                    for (int l : list1) {
                        System.out.println("thread4" +
                                " " +
                                l);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }),
        };

        for (Thread thread : threads) thread.start();
//            for (Thread thread : threads) thread.join();
    }

    public static void ex3() {
        String arr[] = {"X", "Y", "Z"};
        List<String> list = Arrays.asList(arr);
        //swapping elements of Collection we swap elements of original array to
        //result of Arrays.asList(...) realization
        Collections.swap(list, 0, 1);
        System.out.println(Arrays.toString(arr));

        //if we wanna get modifiable collection that doesn't change original args
        arr = new String[]{"X", "Y", "Z"};
        List<String> arrayList = new ArrayList<>(Arrays.asList(arr));
        Collections.swap(arrayList, 0, 1);

        System.out.println(Arrays.toString(arr));
        System.out.println(arrayList);

        //Arrays.asList() args are Object type
        Integer[] a = {10, 20, 30};
        int[] b = {10, 20, 30};
        info(Arrays.asList(a));
        //one object
        info(Arrays.asList(b));
        info(Arrays.asList(1, 2, 3));
    }

    public static void ex4() {
        List<String> list = Arrays.asList("X", "Y", "Z");
        System.out.println(list.getClass());
        System.out.println(list);
        //size modification is not allowed if List was initialized by Arrays.asList(...)
        try {
            list.add("A");
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            list.remove("X");
        } catch (Exception e) {
            System.err.println(e);
        }
        //but elements exchange or setting of new value is still available
        list.set(0, "A");
        System.out.println(list);
        Collections.swap(list, 0, 1);
        System.out.println(list);
        //unmodifiable list
        List<String> unmodifiable = Collections.unmodifiableList(list);
    }

    public static <T> void info(List<T> list) {
        System.out.println("Size " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " -> " + list.get(i));
        }
    }

    public static <T> void show(String name, Spliterator<T> spliterator) {
        StringBuilder stringBuilder = new StringBuilder(name + ": ");
        spliterator.forEachRemaining(e -> stringBuilder.append(' ').append(e));
        System.out.println(stringBuilder);
    }


}

class Customer {
    private String id;
    private Integer purchasedSum;
    private Integer bonus = 0;

    public Customer(String id, Integer purchasedSum) {
        this.id = id;
        this.purchasedSum = purchasedSum;
    }

    public Integer getPurchasedSum() {
        return purchasedSum;
    }

    public String getId() {
        return id;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        String sbonus = bonus > 0 ? " - bonus " + bonus : "";
        return id + ", psum = " + purchasedSum + sbonus;
    }
}
