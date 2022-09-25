package cn.itcast.algorithm.priority;

/**
 * 索引优先队列设计
 * 通过索引访问已存在优先队列中的对象
 *思路 1.用一个T[] items数组来保存数据元素，items不是堆有序的
 * 2.用另一个数组int[] pq 保存item数组的索引，pq数组存item数组的有序索引
 * 3.用另一个数组int[] qp 保存pq的逆序，qp的索引是pq的值，qp的值是pq的索引
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    //存储元素的数组
    private T[] items;
    //保存每个元素在items数组的索引，
    private int[] pq;
    //保存qp数组的逆序，pq的值作为索引，pq的索引作为值
    private int[] qp;
    //记录堆中元素个数
    private int N;


    public IndexMinPriorityQueue(int capacity){
        this.items = (T[])new Comparable[capacity+1];
        this.pq = new int[capacity+1];
        this.qp = new int[capacity+1];
        this.N = 0;
        //默认情况下，队列中没有任何数据，让qp中数据为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    //获取队列中元素的个数
    public int size(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i,int j){
        //交换pq的值
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        //更新qp的数据
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    //删除队列中最小元素，并返回该元素关联的索引
    public int delMin(){
        //获取item最小元素关联的索引
        int minIndex = pq[1];
        //交换pq中索引1处与最大索引的元素
        exch(1,N);
        //删除qp中对应的内容
        qp[pq[N]] = -1;
        //删除pq最大索引处的内容
        pq[N] = -1;
        //删除item中对应的内容
        items[minIndex] = null;
        //元素个数-1
        N--;
        //下沉调整
        sink(1);
      return minIndex;
    }

    //往队列中插入一个元素，并返回该元素关联的索引
    public void insert(int i,T t){
        //判断i是否已经被关联，如果已经被关联则不让插入
        if (contains(i)){
            return;
        }
        //元素个数+1
        N++;
        //把数据存储到items对应的i位置处
        items[i] = t;
        //把i存储到pq中
        pq[N] = i;
        //通过qp记录pq中的i
        qp[i] = N;
        //通过堆上浮完成堆的调整
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //循环到根节点
        while (k > 1){
            //父子节点相比较，如果子节点小于父节点则交换位置
            if (less(k,k/2)){
                exch(k,k/2);
            }
            k = k/2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //下沉 直到 没有子节点
        while (2*k <= N){
            //设置最小值索引，默认左子节点
            int min = 2*k;
            //当存在右子节点且左右子节点比较右子节点小于左子节点，最小值索引更换为右子节点
            if (2*k+1 <= N && less(2*k+1,2*k)){
                min = 2*k+1;
            }

            //如果k节点值小于子节点中较小节点值，跳出循环
            if (less(k,min)){
                break;
            }
            k = min;
        }
    }

    //判断k对应元素是否存在
    public boolean contains(int k){
        //qp初始化值-1
        return qp[k] != -1;
    }

    //把与索引i关联的元素修改为t
    public void changeItem(int i,T t){
        //修改items数组中索引i处值为t
        items[i] = t;
        //找到i在pq中的位置
        int k = qp[i];
        //对pq[k]做下沉，让堆有序
        sink(k);
        //对pq[k]做上浮，让堆有序
        swim(k);
    }

    //最小元素关联的索引
    public int minIndex(){
        //pq是item有序对应的索引数组，最小元素索引就是pq[1]
        return pq[1];
    }

    //删除索引i关联的元素
    public void delete(int i){
        //找到i在pq中的索引
        int k = qp[i];
        //交换pq中k索引处的值和最大索引N处的值
        exch(k,N);
        //删除qp中索引pq[N]处元素
        qp[pq[N]] = -1;
        //删除pq中索引N处的值
        pq[N] = -1;
        //删除items中索引i处的值
        items[i] = null;
        //元素数量-1
        N--;
        //对pq[k]下沉，让堆有序
        sink(k);
        //对pq[k]上浮，让堆有序
        swim(k);
    }
}
