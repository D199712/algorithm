package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Merge;

import java.util.Arrays;

/**
 * @Author DJ
 * @Description //合并排序测试
 * @Date $time$ $date$
 * @return $return$
 */
public class MergeTest {

    public static void main(String[] args) {
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
