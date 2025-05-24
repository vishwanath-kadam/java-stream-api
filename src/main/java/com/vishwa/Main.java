package com.vishwa;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        one();
    }

    private static void one() {
        String intputString = "I am learning Stream API's in JAVA";
        String highest = Arrays.stream(intputString.split(" "))
                .max(Comparator.comparing(String::length))
                .get();
        System.out.println(highest);
    }
}