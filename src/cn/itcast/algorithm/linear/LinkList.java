package cn.itcast.algorithm.linear;


import java.util.Iterator;

/**
 * 单向链表
 */
public class LinkList<T> implements Iterable<T>{

    private class Node{
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    //记录头节点
    private Node head;
    //记录链表长度
    private int N;

    public LinkList(){
        //初始化头结点
        this.head = new Node(null,null);
        //初始化元素个数
        this.N = 0;
    }

    //清空线性表
    public void clear(){
        head.next = null;
        this.N = 0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //判断是否为空
    public boolean isEmpty(){
        return N == 0;
    }


    //读取并返回线性表中第i个元素的值
    public T get(int i){
        Node n = head.next;
        for (int index = 0; index < i;index++){
            n = n.next;
        }
        return n.item;
    }

    //插入一个元素
    public void insert(T t){
        //找到最后一个节点
        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        //创建新节点，保存元素t
        Node newNode = new Node(t,null);
        //让当前最后一个节点指向新节点
        n.next = newNode;
        //元素个数+1
        N++;
    }

    //在线性表第i个元素前插入一个值为t的元素
    public void insert(int i,T t){
        //找到i位置前一个节点
        Node pre = head;
        for (int index = 0; index <= i-1; index++){
            pre = pre.next;
        }
        //找到i位置节点
        Node current = pre.next;
        //创建新节点，并且新节点需要指向原来i位置节点
        Node newNode = new Node(t,current);
        //原来i位置前一个节点指向新节点
        pre.next = newNode;
        //元素个数+1
        N++;

    }

    //删除并返回线性表中第i个数据元素
    public T remove(int i){
        //找到i位置处前一个节点
        Node iPre = head;
        for (int index = 0; index <= i-1; index++){
            iPre = iPre.next;
        }
        //找到i位置的节点
        Node iNode = iPre.next;
        //找到i位置下一个节点
        Node iNext = iNode.next;
        //前一个节点指向下一个节点
        iPre.next = iNext;
        //元素数-1
        N--;
        return iNode.item;
    }

    //返回线性表中首次出现指定的数据元素的位序号，若不存在返回-1
    public int indexOf(T t){
        //从头结点开始，依次找到每一个节点，取出item,和t比较
        Node n = head;
        for (int i =0; n.next != null;i++){
            n = n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    //根据参数n返回对应结点
    public Node returnNodeByIndex(int n){
        Node node = head;
        for (int index = 0; index < n; index++){
            node = node.next;
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Literator();
    }

    private class Literator implements Iterator{
        private Node n;
        public Literator(){
            this.n = head;
        }
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

    public void reverse(){
        if(N==0){
            //空链表不需要反转
            return;
        }
        reverse1(head.next);
    }

    //输入第一个节点，将链表反转
    public Node reverse1(Node curr){
        //当到达最后一个元素
        if (curr.next == null){
            //反转后，头指针指向原节点最后一个元素
            head.next = curr;
            return curr;
        }
        //返回当前节点的上一个节点
        Node pre = reverse1(curr.next);
        pre.next = curr;
        //当前节点下一个结点设为null
        curr.next = null;
        //返回当前节点
        return curr;
    }

    //输入一个节点head，将以head节点为起点的链表反转
    public Node reverse2(Node head){
        //当前节点下一个节点为空，返回当前节点
        if (head.next == null){
            return head;
        }
        /**
         * 1.不要进入递归
         *2.明确递归函数的定义:输入一个节点head，将以head为起点的链表反转，并返回反转后的链表的头结点
         */
        Node last = reverse2(head.next);
        //将头结点的下一个节点的下一个节点指向自己
        head.next.next = head;
        //将头结点下一个节点置空
        head.next = null;
        //返回反转后的链表的头结点
        return last;
    }

    //后驱节点
    Node successor = null;

    public Node reverseN(Node head,int n){
        if(n == 1){
            successor = head.next;
            return head;
        }
        Node last = reverseN(head,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
