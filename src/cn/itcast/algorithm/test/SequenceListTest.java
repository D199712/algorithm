package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.SequenceList;

/**
 * @Author DJ
 * @Description //顺序表测试
 * @Date $time$ $date$
 */
public class SequenceListTest {

    public static void main(String[] args) {
        SequenceList<String> sl = new SequenceList<>(10);
        sl.insert("盖伦");
        sl.insert("提莫");
        sl.insert("瑞兹");
        sl.insert(1,"艾希");

        String result = sl.get(1);
        System.out.println("获取索引1处结果："+result);
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是："+removeResult);
        sl.clear();
        System.out.println("清空后的线性表中元素个数："+sl.length());
    }
}
