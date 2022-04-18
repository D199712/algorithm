package cn.itcast.algorithm.sort;

/**
 * 快速排序
 * 原理：
 *时间复杂度
 */
public class Quick {
    /*
    对数组内元素进行排序
     */
    public static void sort(Comparable[] a){
        int lo= 0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }

    /*
    对数组a内从索引lo到hi之间的元素进行排序
     */
    public static void sort(Comparable[] a,int lo,int hi){
        //安全校验
        if (hi <= lo){
            return;
        }
        //需要对数组中lo索引到hi索引处的元素进行分组（左子组和右子组）
        int partition = partition(a,lo,hi);//返回的是分组的分界值所在的索引，分界值位置变换后的索引

        //让左子组有序
        sort(a,lo,partition-1);
        //让右子组有序
        sort(a,partition+1,hi);
    }

    /*
    对数组a内从索引lo到索引hi之间的元素进行分组，并返回分组界限对应索引
     */
    public static int partition(Comparable[] a,int lo,int hi){

    }

    /**
     * 数组元素i和j交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[j] = a[i];
        a[i] = t;
    }

    /**
     * 比较v元素是否小于w元素
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) <0;

    }
}
