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

    //删除树中key对应的value
    public void delete(Key key){

    }

    //删除指定树x中的key对应的value，并返回删除后的新树
    public Node delete(Node x,Key key){
        if (x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0){
            //新结点的key大于当前结点的key，继续找当前结点的右子结点
            return delete(x.right,key);
        }else if (cmp > 0){
            //新结点的key小于当前结点的key，继续找当前结点的左子结点
            return delete(x.left,key);
        }else {
            //新结点的key等于当前结点的key,当前x就是要删除的结点
            // 1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            if (x.right == null){
                return x.left;
            }

            // 2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点
            if (x.left == null){
                return x.right;
            }

            //3.当前结点的左右子树都存在
            //3.1找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null){
                minNode = minNode.left;
            }

            //3.2删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null){
                //孙节点为空，当前节点左子节点置空，不为空则用左子节点继续循环
                if (n.left.left == null){
                    n.left = null;
                }else {
                    n = n.left;
                }
            }

            //3.3让被删除结点的左子树称为最小结点minNode的左子树，让被删除结点的右子树称为最小结点 minNode的右子树
            minNode.left = x.left;
            minNode.right = x.right;
            //3.4让被删除结点的父节点指向最小结点minNode
            x = minNode;
            N--;
        }
        return x;
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
