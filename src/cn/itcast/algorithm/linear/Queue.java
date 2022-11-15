package cn.itcast.algorithm.linear;

import java.util.Iterator;

/** 队列
 *队列是一种基于先进先出(FIFO)的数据结构，是一种只能在一端进行插入,在另一端进行删除操作的特殊线性表，它
 * 按照先进先出的原则存储数据，先进入的数据，在读取数据时先读被读出来。
 */
public class Queue<T> implements Iterable<T>{
    //记录首节点
    private Node head;
    //记录尾节点
    private Node last;
    //栈中元素个数
    private int N;

    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }

    //判断当前队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //返回队列中元素个数
    public int size(){
        return N;
    }
    //尾插头取
    //向队列中插入元素t
    public void enqueue(T t){
        if (last == null){
            //当前尾节点last 为 null
            last = new Node(t,null);
            head.next = last;
        }else {
            //当前尾节点last不为 null
            Node oldLast = last;
            last = new Node(t,null);
            oldLast.next = last;
        }
        //元素个数+1
        N++;
    }

    //从队列中拿出一个元素
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        ///当队列删除完毕，重置last
        if (isEmpty()){
            last = null;
        }
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T>{
        private Node n;

        public QIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
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
