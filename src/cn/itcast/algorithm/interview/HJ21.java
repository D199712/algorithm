package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1≤n≤100
 *
 * 输入描述：
 * 输入一组密码，长度不超过100个字符。
 *
 * 输出描述：
 * 输出密码变换后的字符串
 *
 * 示例1
 * 输入：
 * YUANzhi1987
 * 输出：
 * zvbo9441987
 *
 * 核心：利用char类型与ASCII码对应关系
 * A-Z 对应 65-90
 * a-z 对应 97-122
 */
public class HJ21 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String target = bf.readLine();
        StringBuffer sb = new StringBuffer();
        for(int i =0;i < target.length();i++){
            //获取第i个字符
            char c = target.charAt(i);
            /**大写字母变成小写之后往后移一位
             * c+33
             */
            if (c >= 'A' && c < 'Z'){
                c = (char)(c + 33);
            }else if(c == 'Z'){
                c = 'a';
            }else if(c >= 'a' && c <='c'){
                c ='2';
            }else if (c >= 'd' && c <= 'f'){
                c ='3';
            }else if(c >= 'g' && c<= 'i'){
                c ='4';
            }else if(c >= 'j' && c<= 'l'){
                c ='5';
            }else if(c >= 'm' && c <='o'){
                c ='6';
            }else if (c >= 'p' && c <= 's'){
                c ='7';
            }else if(c >= 't' && c<= 'v'){
                c ='8';
            }else if(c >= 'w' && c<= 'z'){
                c ='9';
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

}
