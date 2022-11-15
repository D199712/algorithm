package cn.itcast.algorithm.interview;

import java.util.HashSet;
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
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        idea3(sc);
        sc.close();
    }

    public static void idea1(Scanner sc) {
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        //从最后一位开始循环，按照从右向左的阅读顺序
        for(int i = length-1; i >= 0; i--){
            char letter = str.charAt(i);
            //找到当前字符第一次出现的位置
            int firstPosition = str.indexOf(letter);
            //找到当前字符最后一次出现的位置
            int lastPosition = str.lastIndexOf(letter);
            /**返回一个不含重复数字的新的整数
             1.如果第一次出现的位置 == 最后一次出现的位置 说明这个字符值出现一次,直接拼接sb
             2.或者最后一次出现的位置与 == 当前循环的位置 i 直接拼接sb
             当前循环的位置 i 对应数字如果是重复整数，在循环到之后重复整数位置时不会拼接sb
             **/
            if(firstPosition == lastPosition || lastPosition == i){
                sb.append(letter);
            }
        }
        System.out.print(sb.toString());
    }

    /**
     * 利用HashSet的不重复性
     * @param sc
     */
    public static void idea2(Scanner sc) {
        HashSet<Integer> set = new HashSet<>();
        int target = sc.nextInt();
        while (target != 0){
            int temp = target % 10;//取最后一位数
            if(set.add(temp)){//如果能添加进HashSet集合说明无重复
                System.out.print(temp);//输出
            }
            target /= 10;//除以10减去最后一位
        }
    }

    /**
     * String.contains(CharSequence s)方法和String substring(int beginIndex, int endIndex) 方法
     * @param sc
     */
    public static void idea3(Scanner sc) {
        String str = sc.nextLine();
        String res = "";
        for (int i = str.length(); i > 0;i--){
            if (!res.contains(str.substring(i-1,i))){
                res += str.substring(i-1,i);
            }
        }
        System.out.println(res);
    }
}
