package com.mvtechbytes;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class RoyAndAlphaBetaTreesResult {

    static class Node {
        public int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public Node() {}
    }

    static class BinaryTree {

        Node root;

        public void add(int value) {
            root = addRecursive(root, value);
        }

        private Node addRecursive(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            if (value < current.value) {
                current.left = addRecursive(current.left, value);
            } else if (value > current.value) {
                current.right = addRecursive(current.right, value);
            } else {
                // value already exists
                return current;
            }

            return current;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof BinaryTree) {
                return identicalTree(((BinaryTree) obj).root, this.root);
            }
            return false;
        }

        static boolean identicalTree(Node a, Node b) {

            if (a == null && b == null) return true;

            /* 2. both non-empty -> compare them */
            if (a != null && b != null)
                return (a.value == b.value
                        && identicalTree(a.left, b.left)
                        && identicalTree(a.right, b.right));

            /* 3. one empty, one not -> false */
            return false;
        }
    }

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER alpha
     *  2. INTEGER beta
     *  3. INTEGER_ARRAY a
     */
    public static int solve(int alpha, int beta, List<Integer> a) {
        int sum = 0;
        List<int[]> allCombos = new ArrayList<>();
        int[] primitive = a.stream().mapToInt(Integer::intValue).toArray();
        printAllRecursive(a.size(), primitive, allCombos);

        BinaryTree binaryTree;
        List<BinaryTree> listTrees = new ArrayList<>();

        for (Object obj : allCombos) {
            int[] array = (int[]) obj;
            binaryTree = new BinaryTree();
            Node root = new Node(array[0]);
            binaryTree.root = root;
            for (int j = 1; j < array.length; j++) {
                binaryTree.add(array[j]);
            }
            listTrees.add(binaryTree);
        }

        List<BinaryTree> collect = new ArrayList<>();
        for (BinaryTree tree : listTrees) {
            if (!collect.contains(tree)) collect.add(tree);
        }

        for (BinaryTree btree : collect) {
            int midsum = evenOddLevelDifference(btree.root, alpha, beta);
            sum = sum + midsum;
        }

        return sum;

    }

    public static void printAllRecursive(int n, int[] elements, List<int[]> resultSet) {
        if (n == 1) {
            printArray(elements, resultSet);
        } else {
            for (int i = 0; i < n - 1; i++) {
                printAllRecursive(n - 1, elements, resultSet);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            printAllRecursive(n - 1, elements, resultSet);
        }
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static void printArray(int[] input, List<int[]> results) {
        int[] ints = new int[input.length];
        for (int i = 0; i < input.length; i++) ints[i] = input[i];

        results.add(ints);
    }

    public static int evenOddLevelDifference(Node root, int alpha, int beta) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        int evenSum = 0, oddSum = 0;

        while (q.size() != 0) {
            int size = q.size();
            level++;

            while (size > 0) {
                Node temp = q.remove();

                if (level % 2 == 0) evenSum += temp.value;
                else oddSum += temp.value;

                if (temp.left != null) q.add(temp.left);

                if (temp.right != null) q.add(temp.right);
                size--;
            }
        }
        return (evenSum * alpha) - (oddSum * beta);
    }


}

public class RoyAndAlphaBetaTreesSolution {
    public static void main(String[] args) throws IOException {
        String outputPath = "./output.txt";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int alpha = Integer.parseInt(firstMultipleInput[0]);

                int beta = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int result = RoyAndAlphaBetaTreesResult.solve(alpha, beta, a);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
