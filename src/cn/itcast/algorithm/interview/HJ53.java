package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ53 杨辉三角的变形
 *
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数、左上角数和右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 *
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3，输入2则输出-1。
 *
 * 数据范围： 1 \le n \le 10^9 \1≤n≤10
 * 9
 *
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 输出返回的int值
 *
 * 示例1
 * 输入：
 * 4
 * 输出：
 * 3
 *
 *
 * 核心：找规律
 * 除前两行没有偶数
 * n%4求余
 * 结果是 0 第一个偶数位在第三
 * 结果是 1 第一个偶数位在第二
 * 结果是 2 第一个偶数位在第四
 * 结果是 3 第一个偶数位在第二
 */
public class HJ53 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        if(n <= 2){
            System.out.println(-1);
        }else if(n%4 == 0){
            System.out.println(3);
        }else if(n%4 == 1 && n%4 ==3){
            System.out.println(2);
        }else if(n%4 == 2){
            System.out.println(4);
        }
    }
}
