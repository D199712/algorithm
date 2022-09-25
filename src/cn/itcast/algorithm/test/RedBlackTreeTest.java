package cn.itcast.algorithm.test;

import cn.itcast.algorithm.tree.RedBlackTree;

/**
 * 红黑树测试
 */
public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String, String> tree = new RedBlackTree<>();
        tree.put("1","张三");
        tree.put("2","李四");
        tree.put("3","王五");
        tree.put("4","老六");
        System.out.println(tree.size());
        tree.put("1","牛二");
        System.out.println(tree.get("1"));
        System.out.println(tree.get("2"));
        System.out.println(tree.size());
    }
}
