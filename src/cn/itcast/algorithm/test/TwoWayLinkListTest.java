package cn.itcast.algorithm.test;


import cn.itcast.algorithm.linear.TwoWayLinkList;

/**
 * @Author DJ
 * @Description //双向链表测试
 * @Date $time$ $date$
 */
public class TwoWayLinkListTest {

    public static void main(String[] args) {
        TwoWayLinkList<String> sl = new TwoWayLinkList<>();
        sl.insert("盖伦");
        sl.insert("提莫");
        sl.insert("瑞兹");
        sl.insert(1,"艾希");
        sl.insert(1,"卡莎");
        sl.insert(5,"娜美");
        sl.insert(0,"兰博");
        for (String s: sl){
            System.out.println(s);
        }
        System.out.println("----------------------------------");
        System.out.println("第一个元素："+sl.getFirst());
        System.out.println("最后一个元素："+sl.getLast());
        String result = sl.get(1);
        System.out.println("获取索引1处结果："+result);
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是："+removeResult);
        sl.clear();
        System.out.println("清空后的线性表中元素个数："+sl.length());
        System.out.println("第一个元素："+sl.getFirst());
    }
}
