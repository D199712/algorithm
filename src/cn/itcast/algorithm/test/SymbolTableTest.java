package cn.itcast.algorithm.test;

import cn.itcast.algorithm.Symbol.SymbolTable;

/**
 * 符号表
 */
public class SymbolTableTest {
    public static void main(String[] args) {
        //创建符号表对象
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        //put方法
        symbolTable.put(1,"提莫");
        symbolTable.put(2,"盖伦");
        symbolTable.put(3,"卡莎");

        System.out.println("插入完毕后，元素个数："+symbolTable.size());

        symbolTable.put(1,"赵信");
        System.out.println("替换完毕后，元素个数："+symbolTable.size());
        //测试get方法
        System.out.println("替换完毕后，键1对应值："+symbolTable.get(1));

        //测试删除方法
        symbolTable.delete(2);
        System.out.println("删除完毕后，元素个数："+symbolTable.size());
    }
}
