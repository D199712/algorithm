package cn.itcast.algorithm.interview;

import cn.itcast.algorithm.sort.Student;

import java.util.Scanner;

/**
 描述
 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 数据范围：
 输入描述：
 输入一个整数

 输出描述：
 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。

 示例1
 输入：
 180

 输出：
 2 2 3 3 5

 核心思路： 1.正如我们判断数 num 是不是质数时，没必要从 2 一直尝试到 num 一样，此题中的大循环也大可不必写一个到 num 的循环，写到 根号num
 即可，如果此时数字还没有除数，则可判定其本身是一个质数，没有再除下去的必要了，直接打印其本身即可：
 2.Math.sqrt()函数可以开根号
 **/
public class HJ6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();
        long s = (long)(Math.sqrt(input));
        
        for(int i = 2; i <= s; i++){
            if(input % i == 0){

                System.out.print(i+" ");
                input /= i;
                i--;//为了重复质数
            }
        }
        System.out.print(input ==1 ? "": input + " ");
    }}
