package cn.itcast.algorithm.heap;

/**
 * 堆
 */
public class Heap<T extends Comparable<T>> {
    //用来存储元素的数组
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public Heap(int capacity){
        this.items = (T[])new Comparable[capacity+1];
        this.N = 0;
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

    //删除堆中最大的元素,并返回这个最大元素
    public T delMax(){
        T max = items[1];

        //交换索引1处元素和最大索引处元素，让完全二叉树中最右侧的元素变为临时根节点
        exch(1,N);
        //最大索引处的元素删除掉
        items[N] = null;
        //元素个数-1
        N--;
        //通过下沉调整堆，让堆重新有序
        sink(1);
        return max;
    }

    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //如果已经到了根节点，就不需要循环了
        while(k>1){
            if(less(k/2,k)){
                //父节点小于当前节点，需要交换
                exch(k/2,k);
            }
            k = k/2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //通过循环不断对比当前k节点和左子节点2*k,右子节点2*k+1处元素大小，如果当前节点小，则需交换位置
        while (2*k <= N){
            //找到子节点中较大者
            int max;
            //当存在右子节点
            if (2*k+1 < N){
                //左右子节点相互比较,将最大者索引赋予max
                if (less(2*k,2*k+1)){
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }
            }else {//不存在右子节点
                max = 2*k;
            }
            //比较当前节点和子节点较大者，若当前节点大结束循环
            if (!less(k,max)){
                break;
            }
            //若当前节点小交换值
            exch(k,max);
            k = max;
        }
    }
}
