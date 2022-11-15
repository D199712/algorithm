package cn.itcast.algorithm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是“相同”的错误记录。
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
 * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
 *
 * 数据范围：错误记录数量满足 1 \le n \le 100 \1≤n≤100  ，每条记录长度满足 1 \le len \le 100 \1≤len≤100
 * 输入描述：
 * 每组只包含一个测试用例。一个测试用例包含一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 * 输出描述：
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 *
 * 示例1
 * 输入：
 * D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
 * E:\je\rzuwnjvnuz 633
 * C:\km\tgjwpb\gy\atl 637
 * F:\weioj\hadd\connsh\rwyfvzsopsuiqjnr 647
 * E:\ns\mfwj\wqkoki\eez 648
 * D:\cfmwafhhgeyawnool 649
 * E:\czt\opwip\osnll\c 637
 * G:\nt\f 633
 * F:\fop\ywzqaop 631
 * F:\yay\jc\ywzqaop 631
 * D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
 *
 * 输出：
 * rzuwnjvnuz 633 1
 * atl 637 1
 * rwyfvzsopsuiqjnr 647 1
 * eez 648 1
 * fmwafhhgeyawnool 649 1
 * c 637 1
 * f 633 1
 * ywzqaop 631 2
 *
 */
public class HJ19 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        /**
         * LinkedHashMap类是HashMap的子类，它可以依照插入的顺序来存储元素，
         * LinkedHashMap的存储结构采用了双重链表，因此元素的增加、修改和删除效率都比较高。
         *
         * 解决：循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
         */
        LinkedHashMap<String,Integer> map = new LinkedHashMap<String, Integer>();
        String target;
        while((target = bf.readLine()) != null){
//           String[] str = target.split("\\s+");
//            String fileName = str[0].substring(str[0].lastIndexOf("\\")+1);
//            /**
//             * Math.max(fileName.length()-16,0) 判断文件名是否大于16并处理
//             * str[1] 行号
//             */
//            String key = fileName.substring(Math.max(fileName.length()-16,0))+" "+str[1];
//            //判断map的key值是否包括当前文件名，如果包括，value+1，否则
//            if (map.containsKey(key)){
//                map.put(key,map.get(key)+1);
//            }else {
//                map.put(key,1);
//            }
        int index1 = target.lastIndexOf(" ");
        int index2 = target.lastIndexOf("\\");
        String key = (index1-index2)>16?target.substring(index1-16):target.substring(index2+1);
        map.put(key,map.getOrDefault(key,0)+1);
        }
        int count =0;
        for(String k:map.keySet()){
            if(map.size() - count <=8){
                System.out.println(k+" "+map.get(k));
            }
            count++;
        }
    }
}
