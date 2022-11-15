package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 正则表达式练习
 */
public class regularExpression {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String target;

        while((target = bf.readLine()) != null) {
            if (target.matches("[a-z]+")){
                System.out.println(target+"通过校验");
            }else {
                System.out.println(target+"未通过校验");
            }
        }
    }
}
