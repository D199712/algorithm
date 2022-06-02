package cn.itcast.algorithm.linear;

import java.util.Iterator;

/**
 * 双向链表
 */
public class TwoWayLinkList<T> implements Iterable<T>{


    //记录首节点
    private Node head;
    //尾节点
    private Node last;
    //记录链表长度
    private int N;


    //节点类
    private class Node{
        public Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
        //存储数据
        public T item;
        //指向上一个节点
        public Node pre;
        //指向下一个节点
        public Node next;
    }


    public TwoWayLinkList(){
        //初始化头结点和尾节点
        this.head = new Node(null,null,null);
        //初始化元素个数
        this.N = 0;
    }


    //清空链表
    public void clear(){
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;
        this.N = 0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }


    //往线性表中添加一个元素
    public void insert(T t){
        //若链表为空
        if (isEmpty()){
            //创建新节点
            Node newNode = new Node(t,head,null);
            //让新节点成为尾节点
            last = newNode;
            //让头结点指向尾节点
            head.next = last;
        }else {
            //若链表不为空
            Node oldLast = last;
            //创建新节点
            Node newNode = new Node(t,oldLast,null);
            //让当前尾节点指向新节点
            oldLast.next = newNode;
            //让新节点成为尾节点
            last = newNode;
        }
        //元素个数+1
        N++;
    }

    //在线性表第i个元素前插入一个值为t的元素
    public void insert(int i,T t){
        if (i<0 || i>=N){ throw new RuntimeException("位置不合法"); }
        //找到i位置前一个节点
        Node pre = head;
        for (int index = 0;index < i;i++){
            pre = pre.next;
        }
        //找到i位置节点
        Node curr = pre.next;
        //创建新节点
        Node newNode = new Node(t,pre,curr);
        //让i位置前一个节点的下个节点变为新节点
        pre.next = newNode;
        //让i位置的前一个节点变为新节点
        curr.pre = newNode;
        //元素个数+1
        N++;
    }

    //删除并返回线性表中第i个数据元素
    public T remove(int i){
        if (i<0 || i>N){
            throw new RuntimeException("i超出范围");
        }
        //寻找i位置处前一个元素
        Node pre = head;
        for (int index = 0;index < i;i++){
            pre = pre.next;
        }
        //i位置处元素
        Node curr = pre.next;
        //i位置处下一个元素
        Node next = curr.next;
        //i前一个元素尾节点指向i位置处下一个元素
        pre.next = next;
        //i位置处下一个元素头结点指向i前一个元素
        next.pre = pre;
        //元素个数-1
        N--;
        return curr.item;
    }

    //读取并返回线性表第i个元素的值
    public T get(int i){
        Node n = head.next;
        for (int index=0;index < i;index++){
            //双向链表头结点不存数据，算作-1
            n=n.next;
        }
        return n.item;
    }

    //返回线性表中首次出现指定的数据元素的位序号，若不存在返回-1
    public int indexOf(T t){
        Node n = head;
        for (int i=0;n.next != null;i++){
            n=n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    //获取第一个元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }

    //获得最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }
    @Override
    public Iterator iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{
        private Node n = head;
        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

}
