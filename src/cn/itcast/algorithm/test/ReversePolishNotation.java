package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.Stack;

/**
 * 逆波兰表达式
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        //中缀表达式3*（17-15）+18/6的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    /**
     * @param notation 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    public static int calculate(String[] notation) {
        //1.创建一个栈对象oprands存操作数
        Stack<Integer> oprands = new Stack<>();
        //2.从左往右遍历波兰表达式，得到每一个字符串
        for (int i = 0; i < notation.length; i++) {
            String curr = notation[i];
            Integer o1;
            Integer o2;
            Integer result;
            //3.判断该字符串是不是运算符，如果不是，把该操作数压入oprands栈中
            switch (curr) {
                //4.如果是运算符,从oprands栈中弹出两个操作数o1,o2
                //5.使用该运算符计算o1和o2,得到结果result
                case "+":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 + o2;
                    oprands.push(result);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 - o1;
                    oprands.push(result);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o1 * o2;
                    oprands.push(result);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 / o1;
                    oprands.push(result);
                    break;
                default:
                    //6.把该结果压入oprands栈中
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }
        //7.遍历结束后，拿出栈中最终的结果返回
        int result = oprands.pop();
        return result;
    }
}
