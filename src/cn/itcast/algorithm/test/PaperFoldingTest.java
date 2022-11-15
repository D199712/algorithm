package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.Queue;

/**
 * 折纸问题
 */
public class PaperFoldingTest {
    public static void main(String[] args) {
        //产生树
        Node<String> tree = createTree(2);
        //打印节点
        printTree(tree);
    }

    //通过模拟对折N次纸，产生树
    public static Node createTree(int N){
        //插入根节点
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            //1.第一次对折
            if (i == 0) {
                root = new Node<>("down",null,null);
            }else {
                //2.不是第一次对折
                //创建队列保存，通过层序遍历的方法，找到叶子节点，叶子节点添加为子节点
                Queue<Node> queue = new Queue<>();
                queue.enqueue(root);

                //循环遍历队列
                while (!queue.isEmpty()) {
                    //从队列中弹出一个节点
                    Node<String> tmp = queue.dequeue();

                    //如果有左子结点，将左子结点放入队列
                    if (tmp.left != null) {
                        queue.enqueue(tmp.left);
                    }

                    //如果有右子结点，将右子结点放入队列
                    if (tmp.right != null) {
                        queue.enqueue(tmp.right);
                    }

                    //如果同时没有左子结点和右子节点，那么此结点是叶子节点，给该节点加上左子结点和右子节点
                    if (tmp.left == null && tmp.right == null) {
                        tmp.left = new Node<>("down", null, null);
                        tmp.right = new Node<>("up", null, null);
                    }
                }
            }
        }
        return root;
    }

    //打印树中每个节点
    public static void printTree(Node<String> root){
        //中序遍历
        if (root == null){
            return;
        }
        //打印左子树的每个节点
        if (root.left != null){
            printTree(root.left);
        }
        //打印当前节点
        System.out.print(root.item+" ");
        //打印右子树的每个节点
        if (root.right != null){
            printTree(root.right);
        }
    }

    private static class Node<T>{
        public T item;//存储元素
        public Node left;//
        public Node right;

        public Node(T item,Node left,Node right){
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
