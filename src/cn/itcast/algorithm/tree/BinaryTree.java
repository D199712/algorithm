package cn.itcast.algorithm.tree;

import cn.itcast.algorithm.linear.Queue;

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
            //如果key等于x节点的键，则替换x节点的值为value
            x.value = value;
        }
        return x;
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
        root = delete(root,key);
    }

    //删除指定树x中的key对应的value，并返回删除后的新树
    public Node delete(Node x,Key key){
        if (x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0){
            //待删除结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = delete(x.right,key);
        }else if (cmp < 0){
            //待删除结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = delete(x.left,key);
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
                //孙节点为空，当前节点左子节点设为左子结点的右子节点（防止节点丢失），不为空则用左子节点继续循环
                if (n.left.left == null){
                    n.left = n.left.right;
                }else {
                    n = n.left;
                }
            }

            //3.3让被删除结点的左子树成为最小结点minNode的左子树，让被删除结点的右子树成为最小结点minNode的右子树
            minNode.left = x.left;
            if (minNode == x.right){
                minNode.right = x.right.right;
            }else {
                minNode.right = x.right;
            }
            //3.4让被删除结点的父节点指向最小结点minNode
           if (x == root){
               root = minNode;
           }else {
               x = minNode;
           }
            N--;
        }
        return x;
    }

    //找出整个树中最小的键
    public Key min(){
        return min(root).key;
    }

    //找出指定树中最小的键所在的节点
    public Node min(Node x){
        if (x.left != null){
            return min(x.left);
        }else {
            return x;
        }
    }

    //找出整个树中最大的键
    public Key max(){
        return max(root).key;
    }

    //找出整个树中最大的键所在节点
    public Node max(Node x){
        if (x.right != null){
            return max(x.right);
        }else {
            return x;
        }
    }

    //前序遍历 获取整个树中所有键
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }
    //前序根左右
    //使用前序遍历，将指定树x中所有键放入key队列中
    public void preErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }
        //1.把当前节点的key放到队列
        keys.enqueue(x.key);
        //2.找到当前节点的左子树，如果不为空，遍历递归左子树
        if (x.left != null){
            preErgodic(x.left,keys);
        }
        //3.找到当前节点右子树，如果不为空，遍历递归右子树
        if (x.right != null){
            preErgodic(x.right,keys);
        }
    }

    //中序左根右
    //中序遍历，获取树中所有键
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    //使用中序遍历，将指定树x中所有键放入key队列中
    public void midErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }

        //1.找到当前节点的左子树，如果不为空，遍历递归左子树
        if (x.left != null){
            midErgodic(x.left,keys);
        }

        //2.把当前节点的key放到队列
        keys.enqueue(x.key);

        //3.找到当前节点右子树，如果不为空，遍历递归右子树
        if (x.right != null){
            midErgodic(x.right,keys);
        }
    }

    //后序左右根
    //后序遍历，获取树中所有键
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }

    //使用后序遍历，将指定树x中所有键放入key队列中
    public void afterErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }

        //1.找到当前节点的左子树，如果不为空，遍历递归左子树
        if (x.left != null){
            afterErgodic(x.left,keys);
        }

        //2.找到当前节点右子树，如果不为空，遍历递归右子树
        if (x.right != null){
            afterErgodic(x.right,keys);
        }

        //3.把当前节点的key放到队列
        keys.enqueue(x.key);

    }

    //使用层序遍历，获取树种所有键
    public Queue<Key> layerErgodic(){
        //定义两个队列，分别存储树中的键和树中的节点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //在队列中放入根节点
        nodes.enqueue(root);


        while (!nodes.isEmpty()){
            //从nodes队列中拿出一个节点，同时将key放到keys里
            Node n = nodes.dequeue();
            keys.enqueue(n.key);

            //判断当前节点还有没有左子节点如果有放入队列nodes中
            if (n.left != null){
                nodes.enqueue(n.left);
            }
            //判断当前节点还有没有右子节点如果有放入队列nodes中
            if (n.right != null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }

    //获取整个树最大深度
    public int maxDepth(){
        return maxDepth(root);
    }

    //获取指定树最大深度
    public int maxDepth(Node x){
        if (x==null){
            return 0;
        }
        if (x.left == null && x.right ==null){
            return 1;
        }
        //x的最大深度
        int max = 0;
        //左子树的最大深度
        int maxL = 0;
        //右子树的最大深度
        int maxR = 0;

        //计算x结点左子树最大深度
        if(x.left != null){
            maxL = maxDepth(x.left);
        }
        //计算x结点右子树最大深度
        if (x.right != null){
            maxR = maxDepth(x.right);
        }
        //比较左右子树最大深度，最大值+1
        max = maxL>maxR?maxL+1:maxR+1;
        return max;
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
