package cn.itcast.algorithm.test;

import cn.itcast.algorithm.heap.HeapSort;

import java.util.Arrays;

/**
 * 堆排序测试
 */
public class HeapSortTest {
    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
