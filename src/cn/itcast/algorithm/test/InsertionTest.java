package cn.itcast.algorithm.test;


import cn.itcast.algorithm.sort.Insertion;

import java.util.Arrays;

/**
 * 插入排序测试
 */
public class InsertionTest {
    public static void main(String[] args) {
        //原始数据
        Integer[] a = {4,6,8,7,9,2,10,1};
        Insertion.sort(a);
        Integer[] b = {10,9,8,7,6,5,4,3};
        Insertion.sort(b);
        System.out.println(Arrays.toString(a));
    }
}
