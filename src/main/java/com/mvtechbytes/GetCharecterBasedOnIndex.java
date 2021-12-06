package com.mvtechbytes;

public class GetCharecterBasedOnIndex {

    public static void main(String[] args) {
        String str = "JavaTutorials";
        System.out.println("usingJavaBasics :  " + usingJavaBasics(str, 3));
        System.out.println("usingJavaBasics : " + usingJava8(str, 3));
    }

    private static char usingJavaBasics(String str, int index){

        return str.charAt(index);
    }

    private static char usingJava8(String str, int index){

        return str.chars() // Convert String into IntStream
                .mapToObj(ch -> (char)ch) // Convert Stream<Character> into Character[]
                .toArray(Character[] :: new)[index]; // and get the element at the specific index
    }
}
