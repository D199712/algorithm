package cn.itcast.algorithm.interview;

import java.util.Scanner;

public class deleteNum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            deleteNum(n);
        }
        scan.close();

    }

    public static void deleteNum(int n){
        int index = 0;//元素下标
        int[] flag = new int[n];//新建数组保存旧数组中数据是否被删除
        int inteval = 0;//标记间隔，满3重置为0
        int count_num = 0;//删除元素个数

        //删除元素个数<n 继续循环
        while(count_num < n){

            for (int i =0;i !=n;i++){
                //
                if (flag[i] ==0){
                    inteval++;
                    //间隔为3删除一位元素
                    if (inteval == 3){
                        flag[i] = 1;//更新删除标记位
                        inteval = 0;//重置间隔
                        index = i;//保存元素下标
                        count_num++;
                    }
                }
            }

        }
        System.out.println(index);
    }
}
