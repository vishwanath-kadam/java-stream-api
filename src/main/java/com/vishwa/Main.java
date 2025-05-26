package com.vishwa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
//        one();
//        two();
//        two_1();
//        three();
//        four();
//        five();
//        six();
        seven();
    }

    private static void seven() {
        int [] ints = {1,2,3,4,5,6,7,8,9};
        List<Integer> integerList = Arrays.stream(ints).boxed().toList();
        Map<Boolean, List<Integer>> checkedList = integerList.stream().collect(Collectors.groupingBy(x->x%2==0, Collectors.toList()));
        System.out.println(checkedList);

        List<List<Integer>> listStream = integerList.stream().collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()))
                .entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        System.out.println(listStream);
    }

    private static void six() {
        String intputString = "I am learning Stream API's in JAVA";
        Arrays.stream(intputString.split(" "))
                .filter(s->s.replaceAll("[^aeiouAEIOU]", "").length() == 2)
                .forEach(System.out::println);
    }

    private static void five() {
        String intputString = "I am learning Stream API's in JAVA";
        Map<String, Long> wordCount = Arrays.stream(intputString.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(wordCount);

    }

    private static void four() {
        String intputString = "I am learning Stream API's in JAVA";
        Integer secondHighestLength = Arrays.stream(intputString.split(" "))
                .map(s->s.length())
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondHighestLength);
    }

    private static void three() {
        String intputString = "I am learning Stream API's in JAVA";
        String secondHighest = Arrays.stream(intputString.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondHighest);
    }

    private static void two_1() {
        String inputString = "dabcadefg";
        Arrays.stream(inputString.split(""))
                .distinct()
                .forEach(System.out::print);
    }

    private static void two() {
        String inputString = "dabcadefg";
        inputString.chars()
                .distinct()
                .mapToObj(s->(char)s)
                .forEach(System.out::print);
    }

    private static void one() {
        String intputString = "I am learning Stream API's in JAVA";
        String highest = Arrays.stream(intputString.split(" "))
                .max(Comparator.comparing(String::length))
                .get();
        System.out.println(highest);
    }
}