package cn.itcast.algorithm.interview;

import java.util.Random;

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
        /**
         * Math.abs()获取绝对值
         */
        int a = -9;
        double d = -100;
        float f = -99;
        System.out.println("a绝对值："+Math.abs(a));//9
        System.out.println("d绝对值："+Math.abs(d));//100.0
        System.out.println("f绝对值："+Math.abs(f));//99.0
        /**
         *生成随机数
         */
        System.out.println(Math.random());
        Random random = new Random();
        int i = (int)(Math.random()*100);
        int j = random.nextInt(100);//方法重载，参数内容是指定范围
        System.out.println("i:"+i+"\nj:"+j);
    }
}
