package cn.itcast.algorithm.test;

import cn.itcast.algorithm.priority.IndexMinPriorityQueue;

/**
 * 索引优先对列测试
 */
public class IndexMinPriorityQueueTest {
    public static void main(String[] args) {
        IndexMinPriorityQueue queue = new IndexMinPriorityQueue(10);
        queue.insert(0,"A");
        queue.insert(1,"C");
        queue.insert(2,"F");

        queue.changeItem(2,"B");
        while (!queue.isEmpty()){
            int index = queue.delMin();
            System.out.print(index+" ");
        }
    }
}
