package cn.itcast.algorithm.test;

/**
 * 快慢指针
 */
public class LinkedListTest2 {
    public static void main(String[] args) {
        Node<String> first = new Node<String>("a",null);
        Node<String> second = new Node<String>("b",null);
        Node<String> third = new Node<String>("c",null);
        Node<String> fouth = new Node<String>("d",null);
        Node<String> fifth = new Node<String>("e",null);
        Node<String> sixth = new Node<String>("f",null);
        Node<String> seventh = new Node<String>("g",null);

        first.next = second;
        second.next = third;
        third.next  = fouth;
        fouth.next  = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        //查中间值
        String mid  = getMid(first);
        System.out.println("中间值："+mid);
    }

    public static String getMid(Node<String> first){
        Node<String> fast = first;
        Node<String> slow = first;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    private static class Node<T>{
        //存数据
        T item;

        Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }
}
