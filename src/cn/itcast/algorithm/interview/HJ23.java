package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author DJ
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 数据范围：输入的字符串长度满足 1 \le n \le 20 \1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入：
 * aabcddd
 *
 * 输出：
 * aaddd
 */
public class HJ23 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String target = bf.readLine();
        //1.用LinkedHashMap存储每个字符出现几次
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        char[] chars = target.toCharArray();
        for(char c : chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //2.找到出现最少的次数
        int min = Integer.MAX_VALUE;
        for(int times : map.values()){
            min = Math.min(min,times);
        }
        //3.输出--map.value值和最小值相等不输出
        for(char c : chars){
            if (map.get(c) != min){
                System.out.print(c);
            }
        }
    }
}
