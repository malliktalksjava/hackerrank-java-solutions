package com.mvtechbytes;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class TimeConversionResult {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String dt) {
        // Write your code here
        char ap = dt.charAt(dt.length() - 2);
        dt = dt.substring(0, dt.length() - 2);
        if (ap == 'A') {
            int hh = Integer.parseInt(dt.substring(0, 2));
            if (hh == 12) hh = 0;
            String s = Integer.toString(hh);
            if (s.length() == 1) {
                s = "0" + s;
            }
            return s + dt.substring(2, dt.length());
        } else {
            int hh = Integer.parseInt(dt.substring(0, 2));
            if (hh != 12) hh += 12;
            String s = Integer.toString(hh);
            if (s.length() == 1) {
                s = "0" + s;
            }
            return hh + dt.substring(2, dt.length());
        }
    }
}

public class TimeConversionSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversionResult.timeConversion(s);

        System.out.println(result);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
