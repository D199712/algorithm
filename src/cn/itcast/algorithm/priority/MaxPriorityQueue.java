package cn.itcast.algorithm.priority;

/**
 * 最大优先队列
 * @param <T>
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
    //存储堆中元素
    private T[] items;
    //纪录堆中元素个数
    private int N;
    //创建容量为capacity的MaxPriorityQueue对象
    public MaxPriorityQueue(int capacity) {
        this.items = (T[])new Comparable[capacity+1];
        this.N = 0;
    }

    //获取队列中元素的个数
    public int size(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //删除队列中最大的元素,并返回这个最大元素
    public T delMax(){
        T max = items[1];
        exch(1,N);
        items[N] = null;
        N--;
        sink(N);
        return max;
    }

    //往队列中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //如果已经到了根结点，就不需要循环了
        while (k > 1){
            //比较当前结点和其父结点
            if (less(k/2,k)){
                //父结点小于当前结点，需要交换
                exch(k/2,k);
            }
            k = k/2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //循环让当前节点k的左子结点2*k,右子节点2*k+1比较，若当前节点k数值小,交换位置
        while (2*k <= N){
            //毕竟左右子节点大小，存储最大值索引
            int max;
            //如果存在右子节点
            if (2*k+1 < N){
                if (less(2*k,2*k+1)){
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }
            }else {//如果没有右子节点,直接让max=左子结点索引
                max = 2*k;
            }
            //将父节点与左右子节点最大值比较,如果父节点没有max对应节点大，不用互换
            if (!less(k,max)){
                break;
            }
            exch(k,max);
            k = max;
        }
    }
}
