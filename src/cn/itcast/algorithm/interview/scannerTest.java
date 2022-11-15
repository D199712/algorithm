package cn.itcast.algorithm.interview;

import java.util.Scanner;

public class scannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**方法遇见第一个有效字符（非空格，非换行符）时，开始扫描,
        当遇见第一个分隔符或结束符(空格或换行符)时，结束扫描，
         获取扫描到的内容，即获得第一个扫描到的不含空格、换行符的单个字符串。
        String str1 = sc.next();
        System.out.println("next()方法："+str1);**/
//        int n = sc.nextInt();
        /**扫描到一行内容并作为一个字符串而被获取到,包含空格，
         * 换行符结束扫描
         ***/
        String str2 = sc.nextLine();
        String[] str = str2.split(" ");
        System.out.println("nextLine()方法:"+str.toString());



        sc.close();
    }

}
