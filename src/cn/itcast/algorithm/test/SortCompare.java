package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Insertion;
import cn.itcast.algorithm.sort.Merge;
import cn.itcast.algorithm.sort.Shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 排序算法比较
 */
public class SortCompare {

    public static void main(String[] args) throws IOException {
        //1.创建一个ArrayList集合，存放结果数据
        ArrayList<Integer> result = new ArrayList<>();
        //2.读取reverse_arr.txt文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(SortCompare.class.getClassLoader().getResourceAsStream("reverse_arr.txt")));
        String line = null;
        while ((line=reader.readLine())!=null){
            //line是字符串
            result.add(Integer.valueOf(line));
        }
        reader.close();

        Integer[] arr = new Integer[result.size()];
        result.toArray(arr);

//        testShell(arr);//35毫秒
//        testInsert(arr);//31944毫秒
        testMerge(arr);


    }

    //测试希尔排序
    public static void testShell(Integer[] a){
        //1.获取执行开始时间
        long start = System.currentTimeMillis();
        //2.执行算法代码
        Shell.sort(a);
        //3.获取执行完毕的时间
        long end = System.currentTimeMillis();
        //4.输出
        System.out.println("执行时间："+(end-start)+"毫秒");
    }

    //测试插入排序
    public static void testInsert(Integer[] a){
        //1.获取执行开始时间
        long start = System.currentTimeMillis();
        //2.执行算法代码
        Insertion.sort(a);
        //3.获取执行完毕的时间
        long end = System.currentTimeMillis();
        //4.输出
        System.out.println("执行时间："+(end-start)+"毫秒");
    }

    //测试归并排序
    public  static void testMerge(Integer[] a){
        long start = System.currentTimeMillis();
        Merge.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("执行时间："+(end-start)+"毫秒");
    }
}
