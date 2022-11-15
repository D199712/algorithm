package cn.itcast.algorithm.test;

/**
 * @Author DJ
 * @Description //递归
 * @Date $time$ $date$
 * @return $return$
 */
public class TestFactorial {

    public static void main(String[] args) {
        long result = factorial(100000);
        System.out.println("结果："+result);
    }

    public static long factorial(int n){
        if (n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
