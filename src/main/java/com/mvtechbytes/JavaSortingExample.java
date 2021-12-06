package com.mvtechbytes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class JavaSortingExample {
    public static void main(String[] args) {

        String [] strArray = {"Tiger", "Lion", "CAT", "Mat", "FAN", "Lion2"};

        System.out.println("sortListUsingCollections : " +
                sortListUsingCollections(Arrays.asList(strArray.clone())));
        System.out.println("sortListUsingStreams : " +
                sortListUsingStreams(Arrays.asList(strArray.clone())));

    }

    private static List<String> sortListUsingCollections(List<String> list){

        Collections.sort(list);
        //Collections.reverse(list); // un comment if for descending order

        return list;
    }

    private static List<String> sortListUsingStreams(List<String> list){

        return list.stream()
                .sorted()
                //.sorted(Comparator.reverseOrder()) -- for reverse order uncomment this line and comment above line
                .collect(toList());
    }
}
