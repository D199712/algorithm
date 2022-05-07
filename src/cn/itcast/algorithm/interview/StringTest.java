package cn.itcast.algorithm.interview;


import java.util.Scanner;

/**
 * @Author DJ
 * @Description //String 测试
 */
public class StringTest {
    public static void main(String[] args) {
//        String str = "邓杰、张强";
//        String[] names = str.split("、");
//        System.out.println(names[0]);
//        System.out.println(names[1]);

//        String repeatWord ="8119";
//        String result = removeRepeatChar(repeatWord);
//        System.out.println(result);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);
    }

    public static String removeRepeatChar(String str)

    {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i< str.length(); i++ ){

            char charWord = str.charAt(i);

            int firstPosition = str.indexOf(charWord);

            int lastPosition = str.lastIndexOf(charWord);

            if (firstPosition == lastPosition || firstPosition == i) {
                sb.append(charWord);
            }

        }

        return sb.toString();

    }

}
