package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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
}

class ListNode{
    int m_nKey;
    ListNode m_pNext;

    public ListNode(int m_nKey){
        this.m_nKey = m_nKey;
        this.m_pNext = null;
    }
}
