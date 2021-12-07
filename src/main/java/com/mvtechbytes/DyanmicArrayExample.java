package com.mvtechbytes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DyanmicArrayExample {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int total = scan.nextInt();

        List<List<Integer>> mainlist=new ArrayList<>();

        for(int i=0;i<total;i++) {
            int size=scan.nextInt();
            List<Integer> list=new ArrayList();
            for(int j=0;j<size;j++) {
                list.add(scan.nextInt());
            }
            mainlist.add(list);
        }

        int totalprint=scan.nextInt();
        for(int k=0;k<totalprint;k++){
            int row=scan.nextInt();
            int col=scan.nextInt();
            try{
                System.out.println(mainlist.get(row-1).get(col-1));
            }catch(Exception e) {
                System.out.println("ERROR!");
            }
        }
        scan.close();
    }
}
