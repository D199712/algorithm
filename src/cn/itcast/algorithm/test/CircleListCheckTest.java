package cn.itcast.algorithm.test;

/**
 * 单向链表是否有环问题
 */
public class CircleListCheckTest {

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
        seventh.next = third;

        //构建循环链表,最后一个节点连接第一个节点1
        //seventh.next = first;

        boolean isCircle = isCircle(first);
        System.out.println("是否有环："+isCircle);
        Node<String> entrance = getEntrance(first);
        System.out.println("环的入口："+entrance.item);
    }

    /**
     * 判断是否有环
     * @param first
     * @return
     */
    public static boolean isCircle(Node<String> first){
        Node<String> fast = first;
        Node<String> slow = first;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    /**
     * 获得环的入口
     * @param first
     * @return
     */
    public static Node getEntrance(Node<String> first){
        //定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        //遍历链表，先找到环，准备一个临时指针，指向链表首节点，继续遍历，直到临时指针与慢临时指针相遇，相遇时就是环的入口
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            //判断快慢指针是否相遇
            if (fast.equals(slow)){
                temp = first;
                continue;
            }

            //让临时节点开始变换
            if (temp != null){
                temp = temp.next;
                //判断临时指针是否1和慢指针相遇
                if (temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
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
