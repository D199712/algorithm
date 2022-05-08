package cn.itcast.algorithm.interview;

import java.util.Scanner;

/**
 * HJ12 字符串反转
 描述
 输入一个整数，将这个整数以字符串的形式逆序输出
 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001


 数据范围： 0 \le n \le 2^{30}-1 \0≤n≤2
 30
 −1
 输入描述：
 输入一个int整数

 输出描述：
 将这个整数以字符串的形式逆序输出

 示例1
 输入：
 1516000

 输出：
 0006151

 示例2
 输入：
 0

 输出：
 0

 */
public class HJ11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        solution4(sc);
        sc.close();
    }

    public static void solution1(Scanner sc) {
        String str = sc.nextLine();
        int length = str.length();
        for(int i = length-1; i >= 0; i--){
            System.out.print(str.charAt(i));
        }
    }

    /**
     * StringBuffer.reverse()方法 反转字符串
     * @param sc
     */
    public static void solution2(Scanner sc) {
        String target = sc.nextLine();
        StringBuffer sb = new StringBuffer(target);
        sb.reverse();
        System.out.println(sb.toString());
    }

    /**
     * 利用 10进位 特性
     *  do{}while()语法特性 处理 用例 0 的情况
     * @param sc
     */
    public static void solution3(Scanner sc) {
        int target = sc.nextInt();
        do{
            int result = target % 10;
            System.out.print(result);
            target /= 10;
        }while(target > 0);
    }

    /**
     *
     * @param sc
     */
    public static void solution4(Scanner sc) {
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        for(int i=0; i < str.length()/2;i++){
            char temp = c[i];
            c[i] = c[c.length-1-i];
            c[c.length-1-i] = temp;
        }
        //char[]直接转为String字符串
        System.out.println(new String(c));
    }
}

