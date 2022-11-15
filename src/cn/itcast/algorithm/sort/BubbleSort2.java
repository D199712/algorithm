package cn.itcast.algorithm.sort;

import java.util.Arrays;

public class BubbleSort2 {
    /**
     * 冒泡排序：双层for循环，外层控制回合，内层控制元素比较和交换
     * 有序标记：在本回合排序中如果元素未发生交换说明之后的数列已经有序，跳出外循环；
     *          如果元素发生交换说明之后得到数列无序，继续循环
     *有序标记能减少外循环
     * @param array
     */
    public static void sort(int array[]){
        //中间变量tmp
        int tmp = 0;
        //内循环次数
        int innerLoopNum = 0;
        for (int i = 0; i < array.length; i++){
            //有序标记，每一轮开始前初始值为true
            boolean isSorted = true;

            for (int j = 0; j< array.length-1;j++){

                if(array[j] > array[j+1]){
                    tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;

                    //当元素进行交换，说明不是有序的，标记为false
                    isSorted = false;

                }
                ++innerLoopNum;
                System.out.println("内循环"+innerLoopNum);
            }
            System.out.println("第"+i+"回合");
            if (isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
