package cn.itcast.algorithm.sort;

/**
 * 插入排序
 * 需求：
 * 排序前：{4,3,2,10,12,1,5,6}
 * 排序后：{1,2,3,4,5,6,10,12}
 * 排序原理：
 * 1.把所有的元素分为两组，已经排序的和未排序的；
 * 2.找到未排序的组中的第一个元素，向已经排序的组中进行插入；
 * 3.倒叙遍历已经排序的元素，依次和待插入的元素进行比较，直到找到一个元素小于等于待插入元素，那么就把待
 * 插入元素放到这个位置，其他的元素向后移动一位；
 *扑克牌
 * 核心思想：无序插入有序
 * 时间复杂度：O(N^2)
 */
public class Insertion {

    /**
     * 插入排序
     * @param array
     */
    public static void sort(Comparable[] array) {
        int num = 0;
        for (int i =1; i<array.length;i++){

            for (int j=i; j>0;j--){
                if (greater(array[j-1],array[j])){
                    exch(array,j-1,j);
                }else {
                    break;
                }
                num++;
            }
        }
        System.out.println("num"+num);
    }

    /**
     * 比较v元素是否大于w元素
     * @param v
     * @param w
     * @return
     */
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    /**
     * 数据i和j交换位置
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
