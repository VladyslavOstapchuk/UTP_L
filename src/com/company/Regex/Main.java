package com.company.Regex;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
    }

    public static void ex1() {
        String text = "tummy time water mat 2169";
        //Regex template
        Pattern pattern = Pattern.compile("[0-9]*$");
        //Text
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void ex2() {
    }

    public static void ex3() {
    }

    public static void ex4() {
    }

    public static void ex5() {
    }
}
