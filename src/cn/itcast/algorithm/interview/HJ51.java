package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 *
 * 链表结点定义如下：
 * struct ListNode
 * {
 *     int m_nKey;
 *     ListNode* m_pNext;
 * };
 * 正常返回倒数第k个结点指针，异常返回空指针.
 * 要求：
 * (1)正序构建链表;
 * (2)构建后要忘记链表长度。
 * 数据范围：链表长度满足 1≤n≤1000  ， k \le n \k≤n  ，链表中数据满足 0 \le val \le 10000 \0≤val≤10000
 *输入描述：
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 *
 * 输出描述：
 * 输出一个整数
 *
 *8
 *1 2 3 4 5 6 7 8
 *4
 *
 * 5
 */

public class HJ51 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = bf.readLine())!=null){
            int n = Integer.parseInt(str);
            String[] strs = bf.readLine().split(" ");
            int k = Integer.parseInt(bf.readLine());
            ListNode target = new ListNode(-1);
            ListNode list = target;
            for(int i = 0; i < n; i++){
                int value = Integer.parseInt(strs[i]);
                list.m_pNext = new ListNode(value);
                list = list.m_pNext;
            }


            for(int i = 0;i < n-k+1; i++){
                target = target.m_pNext;
            }
            System.out.println(target.m_nKey);
        }
    }
    private static class ListNode{
        int m_nKey;
        ListNode m_pNext;

        public ListNode(int m_nKey){
            this.m_nKey = m_nKey;
            this.m_pNext = null;
        }
    }
}
