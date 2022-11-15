package cn.itcast.algorithm.test;

import cn.itcast.algorithm.priority.MaxPriorityQueue;

/**
 * 最大优先队列
 */
public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        System.out.println(queue.size());
        while (!queue.isEmpty()){
            String del = queue.delMax();
            System.out.print(del+",");
        }
    }
}
