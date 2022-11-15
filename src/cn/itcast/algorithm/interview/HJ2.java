package cn.itcast.algorithm.interview;

import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine().toLowerCase();
        String s = sc.nextLine();
        System.out.println(str.replaceAll(s,""));
    }
}
