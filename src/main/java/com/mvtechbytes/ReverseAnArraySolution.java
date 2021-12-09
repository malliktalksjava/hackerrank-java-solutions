package com.mvtechbytes;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ReverseAnArrayResult {

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {

        java.util.Collections.reverse(a);
        return a;

    }

    public static List<Integer> reverseArray2(List<Integer> a) {
        List<Integer> list = new ArrayList<>();
        int size = a.size();
        for(int i=size-1; i>=0; i--){
            list.add(a.get(i));
        }

        return list;

    }

}

public class ReverseAnArraySolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        ///int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> res = ReverseAnArrayResult.reverseArray(arr);
        List<Integer> res2 = ReverseAnArrayResult.reverseArray2(arr);

        System.out.println("res : " + res);
        System.out.println("res2 : " + res2);
       /* bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
       // bufferedWriter.close();
    }
}
