package com.company.Collections.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //Map
    //HashMap - table
    //TreeMap - tree
    //LinkedHashMap - saves order of added elements
    //WeakHashMap - allows to remove never used key

    public static void main(String[] args) throws Exception {
//        ex1();
//        ex2();
//        ex3();
//        ex4();
//        ex5();
//        ex6();
//        ex7();
//        ex8();
//        ex9();
        ex10();
    }

    public static void ex1() throws FileNotFoundException {
        //key -> value
        Map<String, String> map = new HashMap<>();

        Scanner scanner = new Scanner(new File("D:\\PROJECTS\\UTP\\UTP L\\src\\Firms"));

        String firmName;
        String address;

        while (scanner.hasNextLine()) {
            firmName = scanner.nextLine();
            address = scanner.nextLine();

            //firmName - key, address - value
            map.put(firmName, address);
        }

        System.out.println(map.get("Orange"));
    }

    //Operations with Maps
    public static void ex2() {
        Map<String, String> map = new HashMap();

        //adds element to map or replaces value for given key
        {
            map.put("Orange", "Warsaw");
            map.put("Orange", "Lodz");
            map.put("Tmobile", "Gdansk");
            map.put("Play", "Poznan");
        }

        //check if map contains key
        System.out.println(map.containsKey("Orange") ? "Map contains Orange" : "Map doesn't contain Orange");
        //check if map contains value
        System.out.println(map.containsValue("Gdansk") ? "Map contains value Gdansk" : "Map doesn't contain value Gdansk");
        //get Entry (widok)
        //Entry isn't a copy of map. Change of Entry elements affects on original map
        {
            var entry = map.entrySet();

            for (var m : entry)
                System.out.println(m);
        }
        //get Set of keys
        {
            var keys = map.keySet();

            for (var k : keys)
                System.out.println(k);
        }
        //get collection of values
        {
            var values = map.values();

            for (var v : values)
                System.out.println(v);
        }
        //get value from record by key
        System.out.println(map.get("Orange"));
        //adds or replaces all elements from map
        Map<String, String> tmp = new HashMap<>();
        tmp.putAll(map);
        //removes record by key
        tmp.remove("Orange");
        //clear map
        map.clear();
        //check if map is empty
        System.out.println(map.isEmpty() ? "Map is empty " + map.size() + " elements" : "Map contains some records " + map.size() + " elements");
    }

    //Entry (Widok)
    public static void ex3() {
        Map<String, Integer> map = new HashMap<>();
        MapUtils.fill(map, "a", 1, "b", 2, "c", 3);
        System.out.println(map);

        Set<String> kSet = map.keySet();
        Collection<Integer> vCol = map.values();
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        kSet.remove("a");
        System.out.println(map);

        vCol.remove(2);
        System.out.println(map);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);

        var entry = entryList.get(0);

        String key = entry.getKey();
        Integer oldValue = entry.getValue();

        entry.setValue(oldValue + 10);

        System.out.println("old value of key " + key + " is " + oldValue);
        System.out.println("new value of key " + key + " is " + entry.getValue());
        System.out.println(map);
        //but
        System.out.println(entryList);
        entryList.remove(0);
        System.out.println(entryList);
        System.out.println(map);
    }

    //Collection methods for Entries
    public static void ex4() {
        Map<Integer, Person> students = new HashMap<>();

        students.put(18423, new Person("Vladyslav", "Ostapchuk"));
        students.put(18424, new Person("Jasos", "Biba"));
        students.put(18425, new Person("Misha", "Tomaszew"));

        System.out.println(students);

        Set<Map.Entry<Integer, Person>> studentsEntry = students.entrySet();

        //Entries allow to work with Map like with Collection
        studentsEntry.removeIf(e -> e.getKey() > 18423);
        System.out.println(students);
    }

    //Reading file to Map
    public static void ex5() throws Exception {
        FileReader fileReader = new FileReader("D:\\PROJECTS\\UTP\\UTP L\\src\\Words.txt");
        Scanner scanner = new Scanner(fileReader);
        //Pattern for Search Volume
        Pattern pattern = Pattern.compile("[0-9]*$");
        Matcher matcher;

        Map<String, Integer> keywords = new TreeMap<>();
        String line;

        while (scanner.hasNextLine()) {
            //replacement of extra spaces
            line = scanner.nextLine().replaceAll("\\s+", " ").trim();
            //check
            matcher = pattern.matcher(line);
            if (matcher.find()) {
                keywords.put(
                        line.substring(0, line.length() - matcher.group().length()).trim(),
                        Integer.parseInt(matcher.group())
                );
            } else {
                System.err.println("Wrong format in line containing " + line);
            }
        }

        int removedCount = 0;

        var keyset = keywords.keySet();
        List<String> k = new ArrayList<>(keyset);

        for (int i = 0; i < k.size(); i++) {
            for (int j = 0; j < k.size(); j++) {
                if (i != j) {
                    if (k.get(i).contains(k.get(j))) {
                        keyset.remove(k.get(j));

                        System.out.println(k.get(i) + " | " + k.get(j) + " second is removed");
                        removedCount++;
                    }
                }
            }
        }

        System.out.println("removed = " + removedCount);
    }

    //Map iteration
    public static void ex6() {
        Map<String, String> map = new HashMap();

        //adds element to map or replaces value for given key
        {
            map.put("Orange", "Warsaw");
            map.put("Orange", "Lodz");
            map.put("Tmobile", "Gdansk");
            map.put("Play", "Poznan");
        }

        //First method
        for (Map.Entry<String, String> e : map.entrySet()) {
            String key = e.getKey();
            String value = e.getValue();

            System.out.println("Key = " + key + ", Value = " + value);
        }

        //Second method
        map.forEach((key, value) -> System.out.println("Key = " + key + ", Value = " + value));
    }

    //Another use of map iteration
    public static void ex7() {
        Map<String, Integer> all = new HashMap<>();

        all.put("Adam", 1);
        all.put("Jacek", 3);
        all.put("Mateusz", 5);
        all.put("Kamil", 10);
        all.put("Jasos", 7);

        Map<String, Integer> moreThan5 = new HashMap<>();
        Map<String, Integer> lessThan5 = new HashMap<>();

        all.forEach((k, v) -> {
            if (v > 5) {
                moreThan5.put(k, v);
            } else {
                lessThan5.put(k, v);
            }
        });

        System.out.println(moreThan5);
        System.out.println(lessThan5);
    }

    //Additional methods for Map
    public static void ex8() {
        Map<String, Integer> all = new HashMap<>();

        all.put("Adam", 1);
        all.put("Jacek", 3);
        all.put("Mateusz", 5);
        all.put("Kamil", 10);
        all.put("Maciej", 7);

        //Adds if map doesn't include such key
        all.putIfAbsent("Adam", 12);
        //Removes key if it has such value
        all.remove("Adam", 12);
        //Returns value of key if it exists or default value
        System.out.println(all.getOrDefault("Tobias", 12));
        //Replace value for key
        all.replace("Adam",2);
        //Replace value for key with certain value
        all.replace("Adam",2,3);
        //Replaces all values along lambda
        all.replaceAll((k,v) -> k.equals("Adam") ? 1 : 0);
        System.out.println(all);
    }

    //TreeMap sort
    public static void ex9(){
        List<String> words = Arrays.asList("a","v","c");
        Map<String,Integer> fr = new LinkedHashMap<>();
        words.forEach(w -> fr.put(w, fr.getOrDefault(w,0)+1));
        System.out.println(fr);
        //Compare to String
        Map<String,Integer> st = new TreeMap<>((k1,k2) -> k1.compareTo(k2));
        st.putAll(fr);
        System.out.println(st);
    }

    //Map sort
    public static void ex10(){
        Map<String, Integer> map = new HashMap<>();
        MapUtils.fill(map, "AAA",10, "CCC",7,"BB",2);
        System.out.println(map);
        //Sort map by value
        map = MapUtils.sortMapBy(map,(e1,e2) -> e1.getValue() - e2.getValue());
        //The same
        map = MapUtils.sortMapBy(map,Map.Entry.comparingByKey());
        map = MapUtils.sortMapBy(map,Map.Entry.comparingByValue());
        System.out.println(map);
    }
}

class MapUtils {
    static <K, V> Map<K, V> fill(Map<K, V> map, Object... kvPairs) {
        check(map, kvPairs);

        for (int i = 0; i < kvPairs.length; i += 2) {
            map.put((K) kvPairs[i], (V) kvPairs[i + 1]);
        }
        return map;
    }

    private static <K, V> void check(Map<K, V> map, Object... kvPairs) {
        if (kvPairs.length % 2 != 0)
            throw new IllegalArgumentException("Map.Utils.fill: invalid arg size");

        for (int i = 0; i < kvPairs.length - 2; i++) {
            if (kvPairs[i].getClass() != kvPairs[i + 2].getClass())
                throw new IllegalArgumentException("Map.Utils.fill: invalid arg types");
        }
    }

    public static <K,V> Map<K,V> sortMapBy(Map<K,V> srcMap, Comparator<Map.Entry<K,V>> comp){
        //Get entries
        List<Map.Entry<K,V>> entries = new ArrayList<>(srcMap.entrySet());
        //Sort by comparator
        entries.sort(comp);
        //Add sorted entries to result Map
        LinkedHashMap<K,V> resMap = new LinkedHashMap<>();
        entries.forEach(e->resMap.put(e.getKey(),e.getValue()));
        return resMap;
    }
}

class Person {
    private String name;
    private String surname;

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}