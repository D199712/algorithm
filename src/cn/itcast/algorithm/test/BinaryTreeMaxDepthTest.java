package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.Queue;
import cn.itcast.algorithm.tree.BinaryTree;

public class BinaryTreeMaxDepthTest {
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

        int maxDepth = binaryTree.maxDepth();
        System.out.println(maxDepth);
    }

}
