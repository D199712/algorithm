package cn.itcast.algorithm.interview;

import java.util.Scanner;

/**
 * @Author DJ
描述
输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
保证输入的整数最后一位不是 0 。

数据范围： 1 \le n \le 10^{8} \1≤n≤108

输入描述：
输入一个int型整数

输出描述：
按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

示例1
输入：
9876673
输出：
37689

 */
public class HJ9 {
    public static void Main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        for(int i = length; i > 0; i--){
            char letter = str.charAt(i);
            int firstPosition = str.indexOf(letter);
            int lastPosition = str.lastIndexOf(letter);

            if(firstPosition == lastPosition || firstPosition == i){
                sb.append(letter);
            }
        }
        System.out.print(sb.toString());

    }
}
