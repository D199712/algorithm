package cn.itcast.algorithm.sort;

/**
 * @Author DJ
 * @Description //归并排序
 * 原理：1.尽可能将一组数据拆分成两个元素相等的子组，并对每一个子组进行拆分，直到拆分后的每个子组个数为1为止
 * 2.将相邻的两个子组合并成一个有序的大组
 * 3.不断重复步骤2，最终只有一个组为止
 *
 * 时间复杂度：O(nlogn)
 * 稳定性：稳定
 */
public class Merge {

    private static Comparable[] assist;//归并所需要的辅助数组

    public static void sort(Comparable[] a){
        assist = new Comparable[a.length];
        int lo =0;
        int hi =a.length-1;
        sort(a,lo,hi);
    }

    /**
     * 对数组a中从lo到hi的元素进行排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a,int lo,int hi){
        //安全性校验
        if (hi <= lo){
            return;
        }

        int mid = lo + (hi-lo)/2;
        System.out.println("#####分####");
        System.out.println("mid:"+mid);
        System.out.println("lo:"+lo);
        System.out.println("hi:"+hi);
        //对lo到mid之间的元素进行排序；
        sort(a,lo,mid);
        //对mid+1到hi之间的元素进行排序；
        sort(a,mid+1,hi);
        //对lo到mid这组数据和mid+1到hi这组数据进行归并
        merge(a,lo,mid,hi);
    }

    /**
     * 对数据中，从lo到mid一组，从mid+1到hi一组，对这两组数据进行归并
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a,int lo,int mid,int hi){
        System.out.println("#####治####");
        //定义三个指针
        int i=lo;//辅助数组指针
        int p1=lo;//左子组指针
        int p2=mid+1;//右子组指针
        //遍历，移动p1指针和p2指针，比较对应索引处的值，找出最小的那个，放到辅助数组的对应索引处
        while (p1<=mid && p2<=hi){
            //比较对应索引处的值
            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else {
                assist[i++] =a[p2++];
            }
        }
        //遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while (p1<=mid){
            assist[i++]=a[p1++];
        }
        //遍历，如果p2的指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数组的对应索引处
        while (p2<=hi){
            assist[i++]=a[p2++];
        }
        //把辅助数组的元素拷贝到原数组中
        for (int index =lo;index<=hi;index++){
            a[index] = assist[index];
        }

    }

    /**
     * 比较v元素是否小于W元素
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
