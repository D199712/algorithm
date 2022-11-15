package cn.itcast.algorithm.interview;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 描述
 * 题目标题：
 *
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 * 输入描述：
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 *
 * 输出描述：
 * 输出合并之后的数组
 *
 * 示例1
 * 输入：
 * 3
 * 1 2 5
 * 4
 * -1 0 3 2
 * 输出：
 * -101235
 */
public class HJ80 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int firstArrLen = Integer.parseInt(bf.readLine());
        String[] firstArr = bf.readLine().split(" ");
        int secondArrLen = Integer.parseInt(bf.readLine());
        String[] secondArr = bf.readLine().split(" ");

        ArrayList<Integer> unionArr = new ArrayList<>();

        for (int i = 0; i < firstArrLen; i++){
            unionArr.add(Integer.parseInt(firstArr[i]));
        }
        for (int i = firstArrLen; i < firstArrLen+secondArrLen; i++){
            unionArr.add(Integer.parseInt(secondArr[i-firstArrLen]));
        }

        TreeSet<Integer> treeSet = new TreeSet<>(unionArr);
        Iterator i = treeSet.iterator();
        while (i.hasNext()){
            System.out.print(i.next());
        }
    }

}
