package cn.itcast.algorithm.heap;

/**
 * 堆排序
 */
public class HeapSort {
    //对source数组中的数据从小到大排序
    public static void sort(Comparable[] source){
        //1.创建一个比原数组大1的数组
        Comparable[] heap = new Comparable[source.length+1];
        //2.构造堆
        createHeap(source,heap);
        //3.堆排序
        //3.1定义一个变量，记录heap中未排序元素最大索引
        int N = heap.length-1;
        while (N!=1){
            //3.2交换索引1和最大索引处的值
            exch(heap,1,N);
            //最大索引不参加下沉，因此-1
            N--;
            //3.3对索引1处的元素在0-N范围内做下沉操作
            sink(heap,1,N);
        }
        //4.heap中元素已从小到大排序，拷贝到source
        System.arraycopy(heap,1,source,0,source.length);
    }

    //根据原数组source，构造出堆heap
    private static void createHeap(Comparable[] source, Comparable[] heap){
        //把source中的元素拷贝到heap中，heap就变成无序的堆
        System.arraycopy(source,0,heap,1,source.length);

        //对堆中元素进行下沉调整（从长度的一半开始向索引1处扫描）
        for (int i = (heap.length)/2; i > 0; i--) {
            sink(heap,i,heap.length-1);
        }
    }

    //判断heap堆中索引i处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j])<0;
    }

    //交换heap堆中i索引和j索引处的值
    private static void exch(Comparable[] heap, int i, int j){
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    //在heap堆中，对target处的元素做下沉，范围是0~range。
    private static void sink(Comparable[] heap, int target, int range){
        while (2*target <= range){
            int max;
            //有右子节点
            if (2*target+1 <= range ){
                //左右子节点相互比较
                if (less(heap,2*target,2*target+1)){
                    max = 2*target+1;
                }else {
                    max = 2*target;
                }
            }else{//无右子节点
                max = 2*target;
            }

            if (!less(heap,target,max)){
                break;
            }
            exch(heap,target,max);
            target = max;
        }
    }
}
