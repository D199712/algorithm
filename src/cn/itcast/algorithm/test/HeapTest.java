package cn.itcast.algorithm.test;

import cn.itcast.algorithm.Heap;

/**
 * 堆测试
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(20);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");


        String result;
        while ((result=heap.delMax())!=null){
            System.out.print(result+" ");
        }
    }
}
