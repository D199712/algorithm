package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * HJ60 查找组成一个偶数最接近的两个素数
 * 描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 *
 * 数据范围：输入的数据满足 4 \le n \le 1000 \4≤n≤1000
 * 输入描述：
 * 输入一个大于2的偶数
 *
 * 输出描述：
 * 从小到大输出两个素数
 *
 * 示例1
 * 输入：
 * 20
 * 输出：
 * 7
 * 13
 *
 * 示例2
 * 输入：
 * 4
 * 输出：
 * 2
 * 2
 *
 * 核心思路：
 * 1.先写一个判断素数的方法
 * 2.两个素数一个是i,另一个是n-i,两个素数差值是2*i-n,可能是负数，所以绝对差值=Math.abs(2*i-n)
 * 3.对2-n之间进行循环,在循环外设置min存放差值,设置变量存放两个素数,min初始值不能为0,用循环不停筛选最小差值,
 * 循环结束之后得到最小差值和两个目标素数
 */
public class HJ60 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        //在2-n/2之间循环,
        for (int j = 2; j <= n/2; j++){
            //判断是否满足素数对条件
            if(isPrime(j) && isPrime(n-j)){
                //判断差值是否小于上一组
                if (Math.abs(2*j-n) < min){
                    result[0] = j;
                    result[1] = n-j;
                    min = Math.abs(2*j-n);
                }
            }
        }
        System.out.println(result[0] + "\n" +result[1]);
    }

    //因数只有1和自身
    public static boolean isPrime(int target){
        for(int i = 2; i < target; i++){
            if(target%i == 0){
                return false;
            }
        }
        return true;
    }
}
