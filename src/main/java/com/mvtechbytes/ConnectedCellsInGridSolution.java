package com.mvtechbytes;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ConnectedCellsInGridResult {

    private static int[] nav = {-1, 0, 1};

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int row = matrix.size();
        int column = matrix.get(0).size();
        int max = 0;
        int a[][] = new int[row][column];

        boolean visited[][] = new boolean[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (!visited[i][j]) {
                    int region = region(visited, a, i, j, row, column);

                    max = Math.max(max, region);
                }
            }
        }
        return max;
    }

    private static int region(boolean[][]visited, int [][]a,int row, int col, int m,int n){
        if(row>=m || col >=n || row<0 || col<0 || a[row][col]==0 || visited[row][col])return 0;
        visited[row][col]=true;
        int region=1;
        for(int r:nav){
            for(int c:nav){
                region+=region(visited,a,row+r,col+c,m,n);
            }
        }

        return region;
    }

}

public class ConnectedCellsInGridSolution {
    public static void main(String[] args) throws IOException {
        String outputPath = "./output.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(matrix);

        int result = ConnectedCellsInGridResult.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
