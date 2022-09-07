package cn.itcast.algorithm.symbol;

/**
 * 符号表
 * @param <Key>
 * @param <Value>
 */
public class SymbolTable<Key,Value> {
    //首节点
    private Node head;
    //记录符号表个数
    private int N;

    public SymbolTable(){
        head = new Node(null,null,null);
        N = 0;
    }

    //获取符号表中键值对个数
    public int size(){
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key,Value value){
        //符号表中已经存在键为key的键值对，找到该节点，替换值为value即可
        Node n = head;
        while (n.next != null){
            //变换n
            n = n.next;
            //判断n节点存储键是否为key，如果是，替换n节点的值
            if (n.key.equals(key)){
                n.value = value;
                return;
            }
        }
        //如果符号表中不存在键为key的键值对，创建新的节点，保存要插入的键值对，把新节点插入到链表头部，head.next = 新节点
        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        newNode.next = oldFirst;
        head.next = newNode;
        //元素个数+1
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
