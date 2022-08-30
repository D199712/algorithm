package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.Queue;
import cn.itcast.algorithm.tree.BinaryTree;

public class BinaryTreeTest {
    /**前序中序后序层序**/
    public static void main(String[] args) throws Exception{

        BinaryTree<String, String> binaryTree = new BinaryTree<>();
        binaryTree.put("E","5");
        binaryTree.put("B","2");
        binaryTree.put("G","7");
        binaryTree.put("A","1");
        binaryTree.put("D","4");
        binaryTree.put("F","6");
        binaryTree.put("H","8");
        binaryTree.put("C","3");

        Queue<String> preQueue = binaryTree.preErgodic();
        Queue<String> midQueue = binaryTree.midErgodic();
        Queue<String> afterQueue = binaryTree.afterErgodic();
        Queue<String> layerQueue = binaryTree.layerErgodic();
        for (String key : layerQueue){
            System.out.println(key+"="+binaryTree.get(key));
        }
    }

    /**
    //删除
    public static void main(String[] args) {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        binaryTree.put(3,"张三");
        binaryTree.put(2,"李四");
        binaryTree.put(1,"王五");
        binaryTree.put(4,"赵六");
        binaryTree.put(5,"洪七");
        binaryTree.delete(2);
        binaryTree.delete(3);
        System.out.println("删除后键5对应元素："+binaryTree.get(3));
    }
     **/
}
