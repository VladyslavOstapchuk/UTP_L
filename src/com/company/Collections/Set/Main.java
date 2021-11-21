package com.company.Collections.Set;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    //Collection
    public static void main(String[] args) {
        //abstract class Set
        Set<String> set;
        //Set containing only unique values, is not sorted by default
        Set<String> hashSet = fromFileToSet("src/Firms");
        System.out.println("\nHASHSET\n");
        hashSet.forEach(e -> System.out.println(e + " "));
        System.out.println(hashSet);
        //TreeSet containing keys ordered, it's easy to find any element but it's always sorted
        System.out.println("\nTREESET\n");
        TreeSet treeSet = new TreeSet();
        treeSet.add('y');
        treeSet.add('a');
        treeSet.add('c');
        treeSet.add('b');
        System.out.println(treeSet);
    }

    static Set fromFileToSet(String fileName) {
        Set trg = new HashSet();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                trg.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Wrong file");
            return trg;
        }
        return trg;
    }
}
