package cn.itcast.algorithm.interview;

import java.util.Scanner;
import java.util.TreeMap;

/**
 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。


 提示:
 0 <= index <= 11111111
 1 <= value <= 100000

 输入描述：
 先输入键值对的个数n（1 <= n <= 500）
 接下来n行每行输入成对的index和value值，以空格隔开

 输出描述：
 输出合并后的键值对（多行）

 示例1
 输入：
 4
 0 1
 0 2
 1 2
 3 4
 输出：
 0 3
 1 2
 3 4


 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//键值对个数
        TreeMap<Integer,Integer> map = new TreeMap<>();
        //循环取键值对
        for(int i = 0 ;i < n; i++){
            int key = sc.nextInt();
            int value = sc.nextInt();
            map.put(key,map.getOrDefault(key,0)+value);
        }

        for (Integer integer:map.keySet()){
            System.out.println(integer+" "+map.get(integer));
            }
        }


    }

