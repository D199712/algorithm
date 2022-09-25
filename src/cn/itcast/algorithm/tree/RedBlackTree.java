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
        //return x == null?false:x.color==RED;
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
        //让当前节点h的右子节点的左子节点成为节点h的右子节点
        h.right = hRight.left;
        //让当前节点h成为节点h的右子节点的左子节点
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
     * 当某个节点左子节点是红色，且左子节点的左子节点也是红色，需要右旋
     * @param h
     * @return
     */
    private Node rotateRight(Node h){
        //找出当前节点h的左子节点
        Node hLeft= h.left;
        //找出h的左子节点的右子节点
        Node rHleft = h.left.right;
        //让当前节点h的左子节点的右子节点成为h的左子节点
        h.left = rHleft;
        //让当前节点h成为当前节点h的左子节点的右子节点
        rHleft = h;
        //让当前节点h的color成为左子节点的color
        hLeft.color = h.color;
        //让当前节点h的color变成RED
        h.color = RED;
        //返回当前节点的左子节点
        return hLeft;
    }

    /**
     * 颜色反转，相当于完成拆分4-节点
     * @param h
     */
    private void flipColor(Node h){
        //当前节点color属性值变为RED
        h.color = RED;
        //当前节点左右子节点color属性变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     *在整个树上完成插入操作
     * @param key
     * @param value
     */
    public void put(Key key,Value value){
        //在root整个树上插入key-value
        root = put(root,key,value);
        //让根节点的颜色变成BLACK
        root.color = BLACK;
    }

    /**
     *在指定树中，完成插入操作,并返回添加元素后新的树
     * @param h
     * @param key
     * @param value
     * @return
     */
    private Node put(Node h,Key key,Value value){
        if (h == null){
            //标准的插入操作，和父节点用红链接相连
            N++;
            return new Node(key,value,null,null,RED);
        }

        //比较要插入的键和当前节点的键
        int cmp = key.compareTo(h.key);
        if (cmp < 0){
            //继续寻找左子树插入
            h.left = put(h.left,key,value);
        }else if (cmp > 0){
            //继续寻找右子树插入
            h.right = put(h.right,key,value);
        }else {
            //已经有相同节点存在，修改节点的值
            h.value = value;
        }

        //如果当前节点右链接是红色，左链接是黑色，需要左旋
        if (isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }

        //如果当前节点左子节点和左子节点的左子节点都是红色链接，需要右旋
        if (isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }

        //如果当前节点左子连接和右子链接都是红色，需要颜色反转
        if (isRed(h.left) && isRed(h.right)){
            flipColor(h);
        }

        //返回当前节点
        return h;
    }

    //根据key从树中找出对应值
    public Value get(Key key){
        return get(root,key);
    }

    //从指定的树x中，查找key对应的值
    public Value get(Node x,Key key){
        //如果当前节点为空，返回null
        if (x == null){
            return null;
        }

        //比较当前节点的键和key
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            //如果要查询的节点key小于当前节点x的key，继续寻找当前节点的左子结点
            return get(x.left,key);
        }else if (cmp > 0){
            //如果要查询的节点key大于当前节点x的key，继续寻找当前节点的右子结点
            return get(x.right,key);
        }else {
            //如果要查询的key等于当前结点的key，则树中返回当前结点的value。
            return x.value;
        }
    }

    //获取树中元素个数
    public int size(){
        return N;
    }

    //节点类
    private class Node{
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子节点
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
