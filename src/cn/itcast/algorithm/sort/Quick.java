package cn.itcast.algorithm.sort;

/**
 * 快速排序
 * 原理：1.首先设置一个分界值，通过该分界值将数组分为左右两部分
 * 2.将大于或等于分界值的数据放到数组右边，小于或等于分界值的数据放左边，此时左边部分中各元素
 * 都小于或等于分界值，而右边部分各元素都大于或等于分界值
 * 3.然后，左边和右边的数据可以独立排序，对于左侧的数据又可以取一个分界值，将该部分数据分为
 * 左右两部分，同样左边放较小值，右边放较大值，右侧数组做类似处理
 * 4.重复上述过程，这是一个递归调用
 *时间复杂度：O(nlogn) O(n^2)
 * 稳定性：不稳定
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

    /**
     * 切分原理
     * 1.找一个基准值，定义两个指针指向数组头和尾
     * 2.先从尾部向头部搜索一个比基准值小的元素，搜到后停止，记录指针位置
     * 3.再从头部向尾部搜索一个比基准值大的元素，搜到后停止，记录指针位置
     * 4.交换左指针和右指针下的元素
     * 5.重复2,3,4，直到左指针值大于等于右指针值停止
     * @param a
     * @param lo
     * @param hi
     * @return
     * 对数组a内从索引lo到索引hi之间的元素进行分组，并返回分组界限对应索引
     */
    public static int partition(Comparable[] a,int lo,int hi){
        //确定分界值
        Comparable key = a[lo];
        //定义两个指针，分别指向待切分数组最小索引处和最大索引处下一个位置
        int left = lo;
        int right = hi+1;
        //切分
        while (true){
            //从右向左扫描，移动right指针，找到一个比分界值小的元素，停止
            while (less(key,a[--right])){
                if (right==lo){
                    break;
                }
            }
            //从左向右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left],key)){
                if (left==hi){
                    break;
                }
            }
            //判断left>=right,如果是，元素扫描完毕，停止循环，如果不是交换元素即可
            if (left >=right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        exch(a,lo,right);
        return right;
    }

    /**
     * 数组元素i和j交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 比较v元素是否小于w元素
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;

    }
}
