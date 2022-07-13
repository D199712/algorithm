package cn.itcast.algorithm.Symbol;

/**
 * 有序符号表
 * @param <Key>
 * @param <Value>
 */
public class OrderSymbolTable<Key extends Comparable,Value> {
    //首节点
    private Node head;
    //记录符号表个数
    private int N;

    public OrderSymbolTable(){
        head = new Node(null,null,null);
        N = 0;
    }

    //获取符号表中键值对个数
    public int size(){
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key,Value value){
        //定义两个node变量，记录当前节点和当前节点的上一节点
        Node curr = head.next;
        Node pre = head;
        while (curr != null&&key.compareTo(curr.key) > 0){
            //变换当前节点和前一个节点
            pre = curr;
            curr = curr.next;
        }

        //如果当前节点curr的键和要插入的key一样，则替换
        if (curr != null && key.compareTo(curr.key) == 0){
            curr.value = value;
            return;
        }

        //如果当前节点curr的键和要插入的key不一样，把新的节点插入到curr之前
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
        N++;
    }

    //删除符号表中键为key的键值对
    public void delete(Key key){
        //找到键为key的节点，把该节点从链表删除
        Node n = head;
        while (n.next != null){
            //判断n节点下一个节点是否为key,如果是就删除
            if (n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            //变换n
            n = n.next;
        }
    }

    //从符号表中获取key对应的值
    public Value get(Key key){
        Node n = head;
        while (n.next != null){
            n = n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }

    private class Node{

        //键
        public Key key;
        //值
        public Value value;
        //下一个节点
        public Node next;

        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
