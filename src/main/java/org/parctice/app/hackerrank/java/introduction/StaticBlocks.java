package org.parctice.app.hackerrank.java.introduction;

import java.util.Scanner;

public class StaticBlocks {

    private static boolean flag = false;
    private static int B, H;

    static {
        Scanner in = new Scanner(System.in);
        B = in.nextInt();
        H = in.nextInt();

        flag = B > 0 && H > 0;

        if(!flag){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }

        in.close();
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }

}
