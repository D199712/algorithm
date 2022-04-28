package cn.itcast.algorithm.interview;

import java.util.Scanner;

/**
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：
 * abc
 *
 * 输出：
 * abc00000
 *
 * 核心思路 substring() 方法
 */
public class HJ4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String s = input.nextLine();
            split(s);
        }
    }
    public static void split(String str) {
        while (str.length() >= 8) {
            System.out.println(str.substring(0,8));
            str = str.substring(8);
        }
        if (str.length() < 8 && str.length() > 0) {
            while(str.length() != 8){
                str +="0";
            }
            System.out.println(str);
        }
    }
}
