package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.Queue;
import cn.itcast.algorithm.tree.BinaryTree;

public class BinaryTreeTest {
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
        for (String key : afterQueue){
            System.out.println(key+"="+binaryTree.get(key));
        }
    }
}
