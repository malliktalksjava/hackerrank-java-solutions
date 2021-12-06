package com.mvtechbytes;

public class GetIndexOfCharInString {

    public static void main(String[] args) {

        String str = "Java Tutorials index of example";
        char indexChar = 'T';
        String indexString = "index";

        System.out.println("indexOfChar : " + indexOfChar(str, indexChar));
        System.out.println("indexOfString : " + indexOfString(str, indexString));
        System.out.println("indexOfString : " + indexOfString(str, "a", 4));
    }

    private static int indexOfString(String str, String indexString) {

        return str.indexOf(indexString); //returns index of String value
    }

    private static int indexOfChar(String str, char indexChar){

        return str.indexOf(indexChar);//returns index of char value
    }

    private static int indexOfString(String str, String indexStr, int position){

        return str.indexOf(indexStr, position); //returns index of sub String after 4th index
    }
}
