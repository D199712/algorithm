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
        sl.insert("艾希");
        for (String s: sl){
            System.out.println(s);
        }
        System.out.println("----------------------------------");
        sl.reverse();
        for (String s: sl){
            System.out.println(s);
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        sl.reverseN(sl.returnNodeByIndex(3),2);
        for (String s: sl){
            System.out.println(s);
        }
    }
}
