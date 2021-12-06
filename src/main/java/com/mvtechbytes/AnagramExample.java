package com.mvtechbytes;

import java.util.Arrays;

public class AnagramExample {

    public static void main(String[] args) {
        System.out.println(" one : " + checkAnagram("anagram", "margana"));
    }

    private static boolean checkAnagram(String a, String b){

        char[] list1 = a.toLowerCase().toCharArray();
        char[] list2 = b.toLowerCase().toCharArray();

        Arrays.sort(list1);
        Arrays.sort(list2);

        return Arrays.equals(list1, list2);
    }
}
