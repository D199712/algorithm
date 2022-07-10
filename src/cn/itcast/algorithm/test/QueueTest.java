package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.Queue;

/**
 * 队列测试
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("----------------------");
        String result = queue.dequeue();
        System.out.println("出队列的元素是："+result);
        System.out.println("剩下元素个数："+queue.size());
    }

}
