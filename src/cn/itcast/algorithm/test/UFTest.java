package cn.itcast.algorithm.test;

import cn.itcast.algorithm.UF.UF;

import java.util.Scanner;

/**
 * 并查集测试
 */
public class UFTest {
    public static void main(String[] args) {
        UF uf = new UF(5);
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("请输入第一个要合并元素：");
            int p = scanner.nextInt();
            System.out.println("请输入第二个要合并元素：");
            int q = scanner.nextInt();
            //判断p,q是否在同一个组
            if (uf.connected(p,q)){
                System.out.println("节点"+p+"节点"+q+"已经在同一个组");
                continue;
            }
            uf.union(p,q);
            System.out.println("总共还有"+uf.count()+"个分组");
        }
    }
}
