package cn.itcast.algorithm.tree;


/**
 * 红黑树
 */
public class RedBlackTree<Key extends Comparable<Key>,Value>{
    //根节点
    private Node root;
    //记录树中元素个数
    private int N;
    //红色链接
    private static final boolean RED = true;
    //黑色链接
    private static final boolean BLACK = false;

    /**
     * 判断当前节点的父指向链接是否为红色
     * @param x
     * @return
     */
    private boolean isRed(Node x){
        //空节点默认黑色链接
        if (x == null){
            return false;
        }
        //非空节点判断父指向链接是否为红色
        return x.color == RED;
    }

    /**
     * 左旋
     * 当某个节点左子节点为黑色，右子节点为红色，需要左旋
     * @param h
     * @return
     */
    private Node rotateLeft(Node h){
        //找出当前h节点右子节点
        Node hRight = h.right;
        //找出右子节点的左子节点
        Node lhRight = hRight.left;
        //让当前节点h的右子节点的左子结点成为节点h的右子节点
        h.right = hRight.left;
        //让当前节点h成为节点h的右子节点的左子结点
        hRight.left = h;
        //让当前节点h的color变成右子节点的color
        hRight.color =h.color;
        //让当前节点h的color变成RED
        h.color = RED;
        //返回当前节点的右子节点
        return hRight;
    }

    /**
     * 右旋
     * 当某个节点左子结点是红色，且左子节点的左子节点也是红色，需要右旋
     * @param h
     * @return
     */
    private Node rotateRight(Node h){
        //找出当前节点h的左子节点
        Node hLeft= h.left;
        //找出h的左子节点的右子结点
        Node rHleft = h.left.right;
        //让当前节点h的左子结点的右子节点成为h的左子结点
        h.left = rHleft;
        //让当前节点h成为当前节点h的左子节点的右子结点
        rHleft = h;
        //让当前节点h的color成为左子结点的color
        hLeft.color = h.color;
        //让当前节点h的color变成RED
        h.color = RED;
        //返回当前节点的左子结点
        return h.left;
    }
    //结点类
    private class Node{
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        private Node left;
        //记录右子节点
        private Node right;
        //由其父节点指向它的链接的颜色
        public boolean color;

        public Node(Key key,Value value,Node left,Node right,boolean color){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
}
