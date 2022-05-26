package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * 数据范围：输入的字符串长度满足 1≤n≤100
 * 输入描述：
 * 一组字符串。
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 *
 * 输出：
 * OK
 * NG
 * NG
 * OK
 */
public class HJ20 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String target;

        while((target = bf.readLine()) != null) {
            //长度超8位
            if (target.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            if (isMatch(target)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");

        }
    }

    //包括大小写字母.数字.其它符号,以上四种至少三种
    public static boolean isMatch(String target){
        int characterType = 0;
        Pattern pattern1 = Pattern.compile("\\d+");
        if(pattern1.matcher(target).find()){
            characterType ++;
        }
        Pattern pattern2 = Pattern.compile("[a-z]");
        if(pattern2.matcher(target).find()){
            characterType ++;
        }
        Pattern pattern3 = Pattern.compile("[A-Z]");
        if(pattern3.matcher(target).find()){
            characterType ++;
        }
        Pattern pattern4 = Pattern.compile("[^A-Za-z0-9]");
        if(pattern4.matcher(target).find()){
            characterType ++;
        }
        if(characterType >= 3){
            return false;
        }else {
            return true;
        }
    }

    //检查不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）

}
