package cn.itcast.algorithm.sort;

import java.util.Arrays;

public class BubbleSort1 {
    /**
     * 冒泡排序：双层for循环，外层控制回合，内层控制元素比较和交换
     * @param array
     */
    public static void sort(int array[]){
        int tmp = 0;
        for (int i = 0; i < array.length -1; i++){


            for (int j = 0; j< array.length -i-1;j++){

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
