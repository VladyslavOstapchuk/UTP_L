package com.company.Collections.List;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Collection
    //List title = <ListType> is nice way to work with lists
    public static void main(String[] args) {
        opList();
        opArrayList();
        opLinkedList();
    }

    static List fromFileToList(String fileName) {
        List trg = new ArrayList();
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

    static void opList() {
        List firms = fromFileToList("src/Firms");

        for (int i = 0; i < firms.size(); i++) {
            System.out.print(firms.get(i) + " ");
        }
        System.out.println();
        firms.forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println(firms);
    }

    static void opArrayList() {
        //Realized on arrays
        List arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
    }

    static void opLinkedList() {
        //Realized on double linked list (like in C++)
        List linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
    }
}
