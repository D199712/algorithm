package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2
 * 31
 *  −1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入：
 * 0xAA
 * 输出：
 * 170
 * */
public class HJ5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution1(br);

    }

    /**
     * 16进制前两位是0x,使用substring去掉前两位，再用Long.parseLong方法进行转换
     * @param br
     * @throws IOException
     */
    public static void solution1(BufferedReader br) throws IOException {
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(Long.parseLong(line.substring(2),16));
        }
    }
}
