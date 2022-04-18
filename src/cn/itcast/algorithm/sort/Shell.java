package cn.itcast.algorithm.sort;

/**
 * 希尔排序
 * 排序原理：1.选择一个增长量h，按增长量h作为数据分组的依据，对数据进行分组
 * 2.对分好组的每一组数据完成插入排序
 * 3.减小增长量，最小减为一，重复第二步操作
 */
public class Shell {

    /**
     *希尔排序
     * @param a
     */
    public static void sort(Comparable[] a){
        int N = a.length;
        //确定增长量h的最大值
        int h =1;
        while (h<N/2){
            h=h*2+1;
        }
        System.out.println("增长量："+h);

        //当增长量h小于1，排序结束
        while (h>=1){
            //找到待插入的元素
            /**当h=1，内部变成插入排序
             * 当h=1,数组中部分元素已经变成有序数组
             **/
            for (int i =h;i<N;i++){
                //a[i]就是待插入元素
                //把a[i]插入到a[i-h],a[i-2h],a[i-3h]...序列中
                for (int j=i;j>=h;j-=h){
                    /**a[j]就是待插入元素，依次和a[j-h],a[j-2h],a[j-3h]比较
                    如果a[j]小就交换位置，如果不小于，则无需交换位置**/
                    if (greater(a[j-h],a[j])){
                        exch(a,j-h,j);
                    }else {
                        break;
                    }
                }

            }

            h/=2;
        }//end of while

    }


    /**
     * 比较v元素是否大于W元素
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    /**
     * 数组元素i和j交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t =a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
