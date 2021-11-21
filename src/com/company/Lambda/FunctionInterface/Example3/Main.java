package com.company.Lambda.FunctionInterface.Example3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;


public class Main {
    public static void main(String[] args) {
//        examplesOfFunInterfaces();
        examplesOfUniversalMethods();
    }

    static void examplesOfFunInterfaces() {
        {
            //Test ars
            Predicate<String> p = s -> s.length() > 10;
            System.out.println(p.test("ala ma kota"));
            //Transforms args of first type to the second type
            Function<Integer, String> f = n -> n.toString();
            System.out.println(f.apply(101001).length());
            //Do some operations and return result of the same type
            UnaryOperator<String> u = st -> st + " ma kota";
            System.out.println(u.apply("Ala"));
            //Get some object
            Supplier<LocalDate> s = LocalDate::now;
            System.out.println(s.get());
            //Do some operation without returning result
            Consumer<Item> c1 = item -> item.setPrice(3500);
            Consumer<Item> c2 = System.out::println;

            Item item = new Item("computer", 1500);
            c1.accept(item);
            c2.accept(item);
            //Allows to test two args
            BiPredicate<String, Integer> bp = (str, n) -> str.length() > n;
            System.out.println(bp.test("ala ma kota", 10));
            //Returns result of transformation of two arguments to third type
            BiFunction<String, Integer, String> bf = (xs, i) -> xs + i * 2;
            System.out.println(bf.apply("ala", 101));
            //Do some operations with two args and return result of certain type
            BinaryOperator<String> bo = (s1, s2) -> s1 + s2;
            System.out.println(bo.apply("bear", "cat"));
            //Do some operations with two args without returning result
            BiConsumer<Item, Integer> bic1 = (it, n) -> item.setPrice(n);
            bic1.accept(item, 2000);
            System.out.println(item);

            BiConsumer<Item, Integer> bic2 = Item::setPrice;
            bic2.accept(item, 3000);
            System.out.println(item);
        }
    }

    static void examplesOfUniversalMethods() {
        List<Item> items = generate(10, Item::new);
        for (Item i : items) System.out.println(i);
        System.out.println("============================");
        List<Item> out = findAll(items, e -> e.getTitle().equals("Item"));
        for (Item i : out) System.out.println(i);
        System.out.println("============================");
        process(out, e -> e.setPrice(e.getPrice()+100));
        for (Item i : out) System.out.println(i);
        System.out.println("============================");
        List<Double> itemList = transform(items, Item::getPrice);
        System.out.println(itemList);
        System.out.println("============================");
    }

    //find all elements filtered by p
    static <T> List<T> findAll(Collection<T> src, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T s : src)
            if (p.test(s))
                result.add(s);

        return result;
    }

    //transform all elements by f
    static <S, T> List<T> transform(Collection<S> src, Function<S, T> f) {
        List<T> result = new ArrayList<>();
        for (S s : src)
            result.add(f.apply(s));

        return result;
    }

    //generate list created by s
    static <T> List<T> generate(int n, Supplier<T> s) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            result.add((s.get()));

        return result;
    }

    //change all elements by c
    static <T> void process(Collection<T> src, Consumer<T> c) {
        for (T s : src) c.accept(s);
    }
}

