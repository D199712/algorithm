package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过代码解决。
 Lily使用的图片使用字符"A"到"Z"、"a"到"z"、"0"到"9"表示。

 数据范围：每组输入的字符串长度满足 1≤n≤1000

 输入描述：
 一行，一个字符串，字符串中的每个字符表示一张Lily使用的图片。

 输出描述：
 Lily的所有图片按照从小到大的顺序输出

 示例1
 输入：
 Ihave1nose2hands10fingers

 输出：
 0112Iaadeeefghhinnnorsssv

 */
public class HJ34 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String target = bf.readLine();
        int targetLength = target.length();
        int[] array = new int[targetLength];
        for(int i = 0; i < targetLength; i++){
            char c = target.charAt(i);
            array[i] = (int)c;
        }
        int[] result = shellSort(array);
        for(int z = 0; z < targetLength; z++){
            System.out.print((char)result[z]);
        }
    }

    private static int[] shellSort(int[] array){
        int N = array.length;
        int h = 1;
        while (h<N/2){
            h = h*2+1;
        }
        int tmp = 0;
        while (h>=1){
            for (int i = h; i < N; i++){
                for(int j = i; j>=h; j-=h){
                    if(array[j-h] > array[j]){
                        tmp = array[j-h];
                        array[j-h] = array[j];
                        array[j] = tmp;
                    }else {
                        break;
                    }
                }
            }
            h = h/2;
        }
        return array;
    }
}
