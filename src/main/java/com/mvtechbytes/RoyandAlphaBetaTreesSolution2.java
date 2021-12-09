package com.mvtechbytes;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class RoyandAlphaBetaTreesResult {
    long go(int lo, int hi, int odd) {
        if (lo > hi) {
            return 0;
        }
        if (dp[lo][hi][odd] == -1) {
            long ans = 0;
            for (int root = lo; root <= hi; root++) {
                //consider all BST in left subtree of root
                ans += (go(lo, root - 1, 1 -odd) * cnt[hi - root - 1 + 1]) % MOD;
                if (ans >= MOD) ans -= MOD;
                if (ans < 0) ans += MOD;
                //consider all BST in right subtree
                ans += (go(root + 1, hi, 1 -odd) * cnt[root - 1 - lo + 1]) % MOD;
                if (ans >= MOD) ans -= MOD;
                if (ans < 0) ans += MOD;
                //totTrees is total number of trees considered
                long totTrees = (cnt[hi - root] * cnt[root - lo]) % MOD;
                //remember to add the root as many times for each tree
                ans += (totTrees * ((mul[odd] * a[root]) % MOD)) % MOD;
                if(ans >= MOD) ans -= MOD;
                if (ans < 0) ans += MOD;
            }
            dp[lo][hi][odd] = ans;
        }
        return dp[lo][hi][odd];
    }

    public void solve() throws IOException {
        cnt = generateCatalan(205, MOD);
        cnt[0] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            assert(n <= 200);
            a = new long[n] ;
            mul = new long[2];
            int i = 0;
            for (StringTokenizer tokenizer = new StringTokenizer(br.readLine()); tokenizer.hasMoreTokens(); ) {
                String s = tokenizer.nextToken();
                mul[i ++] = Integer.parseInt(s);
            }
            mul[1] = -mul[1];
            i = 0;
            for (StringTokenizer tokenizer = new StringTokenizer(br.readLine()); tokenizer.hasMoreTokens(); ) {
                String s = tokenizer.nextToken();
                a[i ++] = Integer.parseInt(s);
            }
            assert(i == n);
            Arrays.sort(a);
            dp = new long[n][n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[j][k][l] = -1;
                    }
                }
            }
            pw.println(go(0, n - 1, 0));
        }
        pw.close();
    }

    long[] a;
    long[][][] dp;
    long[] cnt;
    long MOD = (int) (1e9 + 9);
    long[] mul;

    public static long[] generateCatalan(int n, long module) {
        long[] inv = generateReverse(n + 2, module);
        long[] Catalan = new long[n];
        Catalan[1] = 1;
        for (int i = 1; i < n - 1; i++) {
            Catalan[i + 1] = (((2 * (2 * i + 1) * inv[i + 2]) % module) * Catalan[i]) % module;
        }
        return Catalan;
    }

    public static long[] generateReverse(int upTo, long module) {
        long[] result = new long[upTo];
        if (upTo > 1)
            result[1] = 1;
        for (int i = 2; i < upTo; i++)
            result[i] = (module - module / i * result[((int) (module % i))] % module) % module;
        return result;
    }
}

public class RoyandAlphaBetaTreesSolution2 {
    public static void main(String[] args) throws IOException {
        new RoyandAlphaBetaTreesResult().solve();
    }
}