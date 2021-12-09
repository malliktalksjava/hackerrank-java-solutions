package com.mvtechbytes;

import java.io.*;

class PalindromeResult {

    /*
     * Complete the 'shortPalindrome' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int shortPalindrome(String s) {
        int[] freq = new int[26];
        int[][] pairfreq = new int[26][26];
        int[] tripfreq = new int[26];
        final int CONSTANT = 1000000000+7;
        int ans = 0;
        for(char c:s.toCharArray()){
            ans = (ans+tripfreq[c-'a'])%CONSTANT;
            for(int i=0; i<26; i++){
                tripfreq[i] = (tripfreq[i] + pairfreq[i][c-'a'])%CONSTANT;
            }
            for(int i=0; i<26; i++){
                pairfreq[i][c-'a'] = (pairfreq[i][c-'a'] + freq[i])%CONSTANT;
            }
            freq[c-'a']++;
        }
        return ans;
    }

}

public class ShortPolindromeSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        int result = PalindromeResult.shortPalindrome(s);

        System.out.println(result);

        bufferedReader.close();

    }
}
