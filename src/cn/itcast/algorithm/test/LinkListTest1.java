package cn.itcast.algorithm.test;


import cn.itcast.algorithm.linear.LinkList;

/**
 * @Author DJ
 * @Description //顺序表测试
 * @Date $time$ $date$
 */
public class LinkListTest1 {

    public static void main(String[] args) {
        LinkList<String> sl = new LinkList<>();
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
        sl.reverse();
        for (String s: sl){
            System.out.println(s);
        }
    }
}
