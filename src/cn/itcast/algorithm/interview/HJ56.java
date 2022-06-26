package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**HJ56 完全数计算
 * 描述
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 *
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 *
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 *
 * 输入n，请输出n以内(含n)完全数的个数。
 *
 * 数据范围： 1 \le n \le 5 \times 10^{5} \1≤n≤5×10
 * 5
 *
 * 输入描述：
 * 输入一个数字n
 *
 * 输出描述：
 * 输出不超过n的完全数的个数
 *
 * 示例1
 * 输入：
 * 1000
 *
 * 输出：
 * 3
 */
public class HJ56 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int perfectNumber = 0;
        for(int j = 1; j <= n; j++){
            if (isPerfectNumber(j)){
                perfectNumber++;
            }
        }
        System.out.println(perfectNumber);

    }

    public static boolean isPerfectNumber(int target){
        int divisorSum = 0;
        for(int i = 1; i <= target/2; i++){
            if(target%i == 0){
                divisorSum += i;
            }
        }
        return target == divisorSum;
    }
}