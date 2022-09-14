package cn.itcast.algorithm.priority;

/**
 * 最小优先队列
 */
public class MinPriorityQueue<T extends Comparable<T>> {
    //用来存储元素的数组
    private T[] items;
    //记录元素个数
    private int N;
    //创建容量为capacity的MinPriorityQueue对象
    public MinPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    //判断堆中索引i处元素是否小于索引j处元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中索引i和索引j处的值
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //获取队列中元素的个数
    public int size(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //删除队列中最小的元素,并返回这个最小元素
    public T delMin(){
        //最小优先队列，根节点最小
        T min = items[1];
        //交换根节点和最后一个节点
        exch(1,N);
        //释放最后一个节点
        items[N] = null;
        //元素个数-1
        N--;
        //从根节点下沉
        sink(1);
        return min;
    }

    //往队列中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //上浮到根节点停止上浮
        while (k > 1){
            //判断子节点是否小于父节点，小于父节点则交换值
            if (less(k,k/2)){
                exch(k,k/2);
            }
            k = k/2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //判断是否有子节点，没有子节点就沉到底部了
        while (2*k <= N){
            //比较做右子节点大小，存储最小值索引
            int min;
            //判断是否有右子节点，无右子节点直接存储左子节点索引，有右子节点比较左右子节点大小，存储最小值索引
            if (2*k+1 <= N){
                if (less(2*k,2*k+1)){
                    min = 2*k;
                }else {
                    min = 2*k+1;
                }
            }else {
                min = 2*k;
            }

            /**
             * 比较子节点最小值与父节点,如果子节点最小值大于父节点，说明当前索引k处的元素处在正确位置，直接跳出循环
             *如果子节点最小值小于父节点，则说明前索引k处的元素处不在正确位置，交换位置，继续循环
             */
            if (!less(k,min)){
                break;
            }
            exch(k,min);
            k = min;
        }
    }
}
