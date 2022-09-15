package cn.itcast.algorithm.test;

import cn.itcast.algorithm.priority.MinPriorityQueue;

/**
 * 最小优先队列测试
 */
public class MinPeiorityQueueTest {
    public static void main(String[] args) {
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);
        queue.insert("G");
        queue.insert("F");
        queue.insert("E");
        queue.insert("D");
        queue.insert("C");
        queue.insert("B");
        queue.insert("A");

        System.out.println(queue.size());
        while (!queue.isEmpty()){
            String min = queue.delMin();
            System.out.print(min+",");
        }
    }
}
