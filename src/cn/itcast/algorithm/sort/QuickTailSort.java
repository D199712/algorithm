package cn.itcast.algorithm.sort;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 * 适用于大部分数据有序的情况
 */
public class QuickTailSort {

    public static void sort(int array[]){
        int tmp = 0;
        for (int i=0; i<array.length/2;i++){
            //有序标记，每一回合初始值true
            boolean isSorted = true;
            //奇数轮，从左向右比较
            for (int j=i; j<array.length-i-1; j++){
                if (array[j] > array[j+1]){
                    tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                    //有元素交换,说明不是有序的，标记为false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
            //偶数轮之前，重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较
            for (int j=array.length-i-1; j>i; j--){
                if (array[j] < array[j-1]){
                    tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
            }
            if (isSorted){
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
