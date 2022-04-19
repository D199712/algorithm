package cn.itcast.algorithm.sort;

/**
 * 选择排序
 * 需求：
 * 排序前：{4,6,8,7,9,2,10,1}
 * 排序后：{1,2,4,5,7,8,9,10}
 * 排序原理：
 *  1.每一次遍历的过程中，都假定第一个索引处的元素是最小值，和其他索引处的值依次进行比较，如果当前索引处
 * 的值大于其他某个索引处的值，则假定其他某个索引出的值为最小值，最后可以找到最小值所在的索引
 *  2.交换第一个索引处和最小值所在的索引处的值
 *
 *  时间复杂度：O(N^2)
 *  稳定性：不稳定
 */
public class Selection {

    public static void sort(Comparable[] a){
        for (int i=0;i<a.length-1;i++){
            //定义一个变量，记录最小元素所在索引，默认为参与选择排序的第一个元素所在位置
            int minIndex = i;
            for (int j=i+1;j<a.length;j++){
                if (greater(a[minIndex],a[j])){
                    //更换最小值所在索引
                    minIndex = j;
                }
            }

            //交换i索引和minIndex处值
            exch(a,i,minIndex);
            System.out.println("回合数："+i);
        }
    }

    /**
     * 比较v元素是否大于w元素
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    /**
     * 数据元素i和j交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] =a[j];
        a[j] = t;
    }
}
