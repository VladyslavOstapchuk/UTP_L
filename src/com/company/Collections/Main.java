package com.company.Collections;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //Iterable->Collection->Set & List
    public static void main(String[] args) throws Exception {
//        //Constructor
//        {
//            List list = Arrays.asList("Ala", "ma");
//            LinkedList linkedList = new LinkedList(list);
//
//            //returns result of operation
//            System.out.println(linkedList.add("kota"));
//
//            List anotherList = new ArrayList(linkedList);
//            Object array[] = linkedList.toArray();
//
//            System.out.println("list " + linkedList);
//            System.out.println("array " + Arrays.toString(array));
//            System.out.println("anotherList " + anotherList);
//        }
//        //Filter
//        {
//            List list = new ArrayList(Arrays.asList("Ala", "ma", "kota"));
//
//            List<String> result =
//                    (List<String>) list.stream().
//                            filter(s -> s.equals("Ala")).
//                            map(s -> s.toString()).
//                            collect(Collectors.toList());
//            show(result);
//        }
//        //Add from several collections
//        {
//            Set<String> list1 = new HashSet(Arrays.asList("Ala", "ma"));
//            Collections.addAll(list1, "kota", "psa", "rybe");
//            System.out.println(list1);
//            fillCollectionFromArray(list1, new String[]{"myszke", "misia"});
//            System.out.println(list1);
//
//            List arrayList = new ArrayList(list1);
//            show(arrayList);
//
//            //removes last element of collection
//            arrayList.remove(arrayList.size() - 1);
//            show(arrayList);
//        }
//        //removeIf
//        {
//            Set<String> set = new HashSet<>(
//                    Arrays.asList(
//                            "Cypr - wyspa",
//                            "Madagaskar - wyspa",
//                            "Krabi",
//                            "Londyn"
//                    )
//            );
//
//            set.removeIf(s -> !s.endsWith("wyspa"));
//            System.out.println(set);
//        }
//        //Sets
//        {
//            List<String> firms = new ArrayList<>();
//            for (Scanner scanner = new Scanner(new File("D:\\PROJECTS\\UTP\\UTP L\\src\\Firms"));
//                 scanner.hasNext();
//                 firms.add(scanner.nextLine()));
//            //all firms from file
//            System.out.println(firms);
//            //firms without duplicates
//            Set<String> set = new HashSet<>(firms);
//            //firms in the same order as in file
//            Set<String> ihset = new LinkedHashSet<>(firms);
//            //firms in order a-z
//            Set<String> ordset = new TreeSet<>(firms);
//
//            System.out.println(set);
//            System.out.println(ihset);
//            System.out.println(ordset);
//        }
//        //bulk-operations
//        {
//            List<String> firms = new ArrayList<>();
//            for (Scanner scanner = new Scanner(new File("D:\\PROJECTS\\UTP\\UTP L\\src\\Firms"));
//                 scanner.hasNext();
//                 firms.add(scanner.nextLine()));
//
//            List<String> myFirms = new ArrayList<>();
//            for(Scanner scanner = new Scanner(new File("D:\\PROJECTS\\UTP\\UTP L\\src\\MyFirms"));
//                scanner.hasNext();
//                myFirms.add(scanner.nextLine()));
//
//            System.out.println(myFirms);
//            System.out.println(firms);
//
//            Set result = new LinkedHashSet(firms);
//            result.addAll(myFirms);
//            System.out.println(result);
//
//            firms.removeAll(myFirms);
//            myFirms.addAll(firms);
//            System.out.println(myFirms);
//        }
        //maxLenLines
//        {
//            List<String> list = maxLenLines("D:\\PROJECTS\\UTP\\UTP L\\src\\Firms");
//            show(list);
//        }
//        //stream operations
//        {
//            List<String> list = Arrays.asList("ala ma kota",
//                    "xxxyyy",
//                    "asia ma psa",
//                    "tekst",
//                    "abc");
//
//            List<String> result = list.stream().filter(s -> s.length() >= 5 && s.length() <= 7).map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.toList());
//
//            System.out.println(result);
//        }
    }

    //finds all lines where length equal max line length in file
    public static List<String> maxLenLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNextLine())
            lines.add(scanner.nextLine());

        scanner.close();

        List<String> maxLenlines = new ArrayList<>();
        int maxLen = 0;

        for (String s : lines) {
            int len = s.length();

            if (len > maxLen) {
                maxLen = len;
                maxLenlines.clear();
                maxLenlines.add(s);
            } else if (len == maxLen) maxLenlines.add(s);
        }
        return maxLenlines;
    }

    //fill collection from several arrays
    public static <T> void fillCollectionFromArray(Collection<T> c, T[]... arrays) {
        for (T[] arr : arrays)
            for (T elt : arr)
                c.add(elt);
    }

    //shows all elements of the list
    public static void show(List<?> list) {
        for (Object o : list)
            System.out.println(o);
    }

    //must be corrected
    public static void opCollection() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 23, 43, 5, 6, 7, 8);
        //size of list
        System.out.println(list.size());
        //check if list is empty
        System.out.println(list.isEmpty());
        //check if list contains such element
        System.out.println(list.contains(2));
        //add element
        list.add(12);
        //remove (first)first element from list
        System.out.println(list.remove(0));
        //remove (first) if predicate
        System.out.println(list.removeIf(e -> e == 12 ? true : false));
        //adds all elements from another collection
        List<Integer> anotherList = new ArrayList<>();
        System.out.println(anotherList.addAll(list));
        //remove all elements from this collection that containing in other one
        System.out.println(anotherList.removeAll(list));
        //leave only elements that are in other collection
        list.retainAll(anotherList);
        //check if all elements from another collection already exist in this one
        list.containsAll(anotherList);
        //remove all elements from list
        list.clear();
    }
}
