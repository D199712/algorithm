package cn.itcast.algorithm.linear;

import java.util.Iterator;

/**
 * 栈
 * 栈是一种基于先进后出(FILO)的数据结构，是一种只能在一端进行插入和删除操作的特殊线性表。它按照先进后出
 * 的原则存储数据，先进入的数据被压入栈底，最后的数据在栈顶，需要读数据的时候从栈顶开始弹出数据（最后一
 * 个数据被第一个读出来）。
 */
public class Stack<T> implements Iterable<T>{
    //首节点
    private Node head;
    //栈中元素个数
    private int N;

    public Stack(){
        head = new Node(null,null);
        N = 0;
    }

    //判断当前栈中元素个数是否为0
    public boolean isEmpty(){
        return N == 0;
    }

    //把t元素压入栈
    public void push(T t){
        Node oldNext = head.next;
        Node node = new Node(t,oldNext);
        head.next = node;
        //个数+1
        N++;
    }

    //弹出栈顶元素
    public T pop(){
        Node oldNext = head.next;
        if (oldNext == null){
            return null;
        }
        head.next = oldNext.next;
        oldNext.next = null;
        //个数-1
        N--;
        return oldNext.item;
    }

    //获取栈中元素个数
    public int size(){
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIteerator();
    }

    public class SIteerator implements  Iterator<T>{
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            Node node = n.next;
            n = n.next;
            return node.item;
        }
    }

    private class Node{

        public T item;
        public Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }
}
