package cn.itcast.algorithm.test;

import cn.itcast.algorithm.symbol.OrderSymbolTable;

/**有序符号表测试
 * @Author DJ
 * @Description //TODO $end$
 * @Date $time$ $date$
 * @return $return$
 */
public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> symbolTable = new OrderSymbolTable<>();
        symbolTable.put(1,"亚索");
        symbolTable.put(2,"赵信");
        symbolTable.put(4,"嘉文");
        symbolTable.put(6,"盖伦");

        symbolTable.put(3,"永恩");
    }
}
