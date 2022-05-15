package cn.itcast.algorithm.interview;

import java.util.Scanner;

/**
 描述
 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。

 数据范围：保证在 32 位整型数字范围内
 输入描述：
 输入一个整数（int类型）

 输出描述：
 这个数转换成2进制后，输出1的个数

 示例1
 输入：
 5

 输出：
 2

 示例2
 输入：
 0

 输出：
 0


 */
public class HJ15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution3(sc);
        sc.close();
    }

    //一个数对2取余为1时，其二进制表达式最后一位为1，迭代右移一位来依次判断该数二进制表达式中每一位是否为1，直至数值为0则表明所有位已经判断完毕
    public static void solution1(Scanner in) {

        int a = in.nextInt();
        int result=0;
        while(a>0){
            if(1==a%2) result++;
            a>>>=1;
        }
        System.out.println(result);
    }

    public static void solution2(Scanner sc) {
        int target = sc.nextInt();
        int result  = 0;
        do{
            result += target % 2;
            target /= 2;
        }while(target > 0);
        System.out.print(result);
    }

    /**
     * Integer.toBinaryString(target); 十进制转二进制的字符串
     * @param sc
     */
    public static void solution3(Scanner sc) {
        int target = sc.nextInt();
        String  str = Integer.toBinaryString(target);
        String result = str.replaceAll("0","");
        System.out.println(result.length());
    }

    /**
     *Integer.toString(target,2); 十进制转二进制的字符串
     * @param sc
     */
    public static void solution4(Scanner sc) {
        int target = sc.nextInt();
        String str = Integer.toString(target,2);
        String result = str.replaceAll("0","");
        System.out.println(result.length());
    }

}

