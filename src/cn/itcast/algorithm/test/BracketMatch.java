package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.Stack;

/**
 * 给定一个字符串，里边可能包含"()"小括号和其他字符，请编写程序检查该字符串的中的小括号是否成对出现。
 * 例如："(上海)(长安)"：正确匹配
 * "上海((长安))"：正确匹配
 * "上海(长安(北京)(深圳)南京)":正确匹配
 * "上海(长安))"：错误匹配
 * "((上海)长安"：错误匹配
 */
public class BracketMatch {
    public static void main(String[] args) {
        String str = "(fdafds(fafds)))";
        boolean match = isMatch1(str);
        System.out.println(str + "中的括号是否匹配：" + match);
    }

    /**
     * 1.创建一个栈用来存储左括号
     * 2.从左往右遍历字符串，拿到每一个字符
     * 3.判断该字符是不是左括号，如果是，放入栈中存储
     * 4.判断该字符是不是右括号，如果不是，继续下一次循环
     * 5.如果该字符是右括号，则从栈中弹出一个元素t；
     * 6.判断元素t是否为null，如果不是，则证明有对应的左括号，如果不是，则证明没有对应的左括号
     * 7.循环结束后，判断栈中还有没有剩余的左括号，如果有，则不匹配，如果没有，则匹配
     */
    public static boolean isMatch1(String str){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            String target = str.charAt(i)+"";
            if (target.equals("(")){
                stack.push(target);
            }else if(target.equals(")")){
                String t  = stack.pop();
                if (t == null){
                    return false;
                }
            }
        }
        if (stack.size() == 0){
            return true;
        }else {
            return false;
        }

    }
}
