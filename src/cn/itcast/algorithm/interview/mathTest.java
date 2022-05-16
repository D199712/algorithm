package cn.itcast.algorithm.interview;

/**
 * @Author DJ
 * @Description //Math类方法测试
 * @return $return$
 */
public class mathTest {

    public static void main(String[] args) {
        int pos = 16;
        int zero = 0;
        int minus = -1;
        System.out.println(Math.sqrt(pos));//4.0
        System.out.println(Math.sqrt(zero));//0.0
        System.out.println(Math.sqrt(minus));//NaN
        /**
         * Math.min(int a,int b) 比较a,b大小返回最小值
         */
        System.out.println(Math.min(pos,zero));
    }
}
