package cn.itcast.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 排序原理：
 * 1. 比较相邻的元素。如果前一个元素比后一个元素大，就交换这两个元素的位置。
 * 2. 对每一对相邻元素做同样的工作，从开始第一对元素到结尾的最后一对元素。最终最后位置的元素就是最大
 * 值
 * 时间复杂度：O(N^2)
 * 稳定性：稳定
 */
public class BubbleSort1 {
    /**
     * 冒泡排序：双层for循环，外层控制回合，内层控制元素比较和交换
     * @param array
     */
    public static void sort(int[] array){
        int tmp = 0;
        for (int i = 0; i < array.length -1; i++){
            for (int j = 0; j< array.length -i-1;j++){
                System.out.println("i:"+i+" j:"+j);
                if(array[j] > array[j+1]){
                    tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
            System.out.println("第"+i+"回合");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
