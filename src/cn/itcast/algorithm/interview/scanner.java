package cn.itcast.algorithm.interview;

import java.util.Scanner;

/**
 * @Author DJ
 * @Description //TODO $end$
 * @Date $time$ $date$
 * @return $return$
 */
public class scanner {

    public static void main(String[] args) {

        int no = 0;
        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
////            System.out.println(sc.nextInt()+sc.nextInt());
////            String str1 = sc.next();//空格为结束
//            String str2 = sc.nextLine();//enter为结束
////            int i = sc.nextInt();
//            no++;
//            System.out.println(str2);
//            System.out.println("no:"+no);
//        }
//        scanner1(sc);
//        scanner4(sc);
        scanner5(sc);
        sc.close();
    }

    public static void scanner1(Scanner sc){

        int num = sc.nextInt();
        for(int i = 0; i < num; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum = a + b;
            System.out.println(sum);
        }
    }


    public static void scanner2(Scanner sc){

        while (sc.hasNextLine()){
            int sum = 0;
            int n = sc.nextInt();
            if(n==0) {
                break;
            }else{
                for (int i = 0; i < n; i++) {
                    int nextNum = sc.nextInt();
                    sum += nextNum;
                }
            }
            System.out.println(sum);
        }

    }

    public static void scanner3(Scanner sc){
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
                int sum = 0;
                int n = sc.nextInt();
                for(int j = 0; j < n; j++){
                    int num = sc.nextInt();
                    sum += num;
                }
                System.out.println(sum);

        }

    }

    public static void scanner4(Scanner sc){
        while(sc.hasNextLine()){
            int n = sc.nextInt();
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }

    }

    public static void scanner5(Scanner sc){
        while (sc.hasNextLine()){
            int n =0;//求每行数据元素个数
            while (sc.hasNext()){
                n++;
            }
            int sum =0;
            for (int i =0; i < n; i++){
                sum += sc.nextInt();
            }
        }

    }
}
