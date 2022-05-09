package cn.itcast.algorithm.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 描述
 给定 n 个字符串，请对 n 个字符串按照字典序排列。

 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，字符串长度满足 1 \le len \le 100 \1≤len≤100
 输入描述：
 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 输出描述：
 数据输出n行，输出结果为按照字典序排列的字符串。
 示例1
 输入：
 9
 cap
 to
 cat
 card
 two
 too
 up
 boat
 boot

 输出：
 boat
 boot
 cap
 card
 cat
 to
 too
 two
 up

 */
public class HJ14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sortByArray(sc);
        sc.close();
    }

    public static void sortByArray(Scanner sc) {
        /**
         * 因为nextInt()只返回数值类型,nextLine()会读取空格回车并返回,
         * 所以在用nextInt()的时候,输入数字n,然后后面的回车会被作为nextLine()的第一个读取内容,
         * 所以就有个空行,不是循环少一次,而是第一次循环插入的就是个回车换行.
         */
        int n =  Integer.valueOf(sc.nextLine());
        String[] target = new String[n];
        for(int i = 0; i < n; i++){
            System.out.println(i);
            target[i] = sc.nextLine();
        }
        Arrays.sort(target);
        for(int i = 0; i < n; i++){
            System.out.println(target[i]);
        }
    }
}
