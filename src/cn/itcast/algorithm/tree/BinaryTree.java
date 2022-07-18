package cn.itcast.algorithm.tree;

/**二叉树
 * @Author DJ
 * @Description //TODO $end$
 * @Date $time$ $date$
 * @return $return$
 */
public class BinaryTree<Key extends Comparable<Key>, Value>{
    //记录根结点
    private Node root;
    //记录树中元素的个数
    private int N;

    //获取树中元素的个数
    public int size() { return N; }

    //向树中插入一个键值对
    public  void put(Key key,Value value) {
        root = put(root,key,value);
    }

    //给指定树x上，添加键一个键值对，并返回添加后的新树
    private Node put(Node x, Key key, Value value) {
        //如果X子树为空
        if (x == null) {
            N++;
            return new Node(key,value,null,null);
        }
        //如果X子树不为空,比较x节点的键和key的大小
        int cmp = key.compareTo(x.key);
        //如果key大于X节点的键，则继续找X节点右子树
        if (cmp > 0) {
            x.right = put(x.right,key,value);
        }else if (cmp < 0) {
            //如果key小于X节点的键，则继续找X节点左子树
            x.left = put(x.left,key,value);
        }else {
            //如果key等于x节点的键，则替换x节点的value
            x.value = value;
        }
        return null;
    }

    //根据Key,从树中找出对应的值
    public Value get(Key key) {
        return get(root,key);
    }

    //从指定的数x中，查找key对应的值
    public Value get(Node x, Key key) {
         //x为null
        if (x == null) {
            return null;
        }
        //x不为null
        //比较key和X节点键的大小
        //如果X子树不为空,比较x节点的键和key的大小
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            //如果key大于X节点的键，则继续找X节点右子树
            return get(x.right,key);
        }else if (cmp < 0) {
            //如果key小于X节点的键，则继续找X节点左子树
            return get(x.left,key);
        }else {
            //如果key等于x节点的键，则找到了键为key的节点，只需要返回x节点的值
            return x.value;
        }
    }

    private class Node {
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            }

    }
}
