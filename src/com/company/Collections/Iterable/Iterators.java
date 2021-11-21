package com.company.Collections.Iterable;

import java.util.*;

public class Iterators {
    public static void main(String[] args) {
        //class Collection extends interface Iterable that means all collections are iterable
        //Iterator<Type of collection elements> iterator = collection.iterator();
        //next() returns next element
        //remove() removes element returned by last call of func next()
        //hasNext() returns true if func next() can return next element (if it exists)
        //forEachRemaining(Consumer c) does operations on elements remaining after last next() or remove()
        //Iterator is the best way to walk throw collection where elements don't have certain place (It reminds pointer)

        {
            List<String> list = new ArrayList<>(Arrays.asList("Ala", "ma", "kota"));
            Iterator<String> iterator = list.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                iterator.remove();
//iterator.remove(); iterator can remove element that was returned by func next() before
            }

            System.out.println(list);
        }

//        removeGreaterThan()
        {
            Set<Integer> set1 = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 54, 5, 6, 7, 8, 8));
            Set<Integer> set2 = new TreeSet<>(set1);

            removeGreaterThan(set1, 5);
            //default method of class Collection that does the same
            set2.removeIf(e -> e > 5);

            System.out.println(set1);
            System.out.println(set2);
        }

        //possible mistakes
        {
            //remove until sum of removed values less than limit
            Set<Integer> set = new TreeSet(Arrays.asList(1, 2, 3, 3, 4, 5, 65, 6, 7));
            System.out.println(set);

            Integer bound = 5;
            Integer sum = 0;
            Integer limit = 25;

//            set.removeIf(e -> (sum += e) < limit && e > 5); //compilation error

            //right solution

            sum = 0;
            for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
                Integer elt = iterator.next();

                if ((sum += elt) >= limit)
                    break;

                if (iterator.next().compareTo(bound) > 0)
                    iterator.remove();
            }

            System.out.println(set);
        }

//        forEachRemaining()
        {
            List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
            //first element of res is sum of first two list elements and rest of elements are list elements + 1
            List<Integer> res = new LinkedList<>();

            Iterator<Integer> iterator = list.iterator();
            res.add(iterator.next() + iterator.next());

            iterator.forEachRemaining(integer -> res.add(++integer));

            System.out.println(list);
            System.out.println(res);
        }

//        forEach doesn't have break and continue
        {
            List<Integer> inList = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));

            //return works like continue and ends work for certain lambda not for whole loop
            inList.forEach(e -> {
                if(e == 5) return;
                System.out.print(e + " ");
            });
            System.out.println();
            //solution
            try{
                inList.forEach(e ->{
                    if(e == 5)
                        throw new RuntimeException();
                    System.out.print(e + " ");
                });
            } catch (RuntimeException r){return;}
        }

        //forEach references
        {
            List<String> list = new LinkedList<>(Arrays.asList("Ala","ma","kota"));
            list.forEach(e -> System.out.print(e));
            System.out.println();
            list.forEach(System.out::print);
        }
    }

    static <T extends Comparable<T>> void removeGreaterThan(Collection c, T bound) {
        for (Iterator<T> iterator = c.iterator(); iterator.hasNext(); ) {
            if (iterator.next().compareTo(bound) > 0) iterator.remove();
        }
    }
}
