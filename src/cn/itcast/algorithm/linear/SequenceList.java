package cn.itcast.algorithm.linear;

import java.util.Iterator;

/**
 * 顺序表
 * @param <T>
 */
public class SequenceList<T> implements Iterable<T>{
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中的元素个数
    private int N;

    //构造方法
    public SequenceList(int capacity){
        //初始化数组
        this.eles = (T[])new Object[capacity];
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear(){
        this.N = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty(){
        return N==0;
    }

    //获取线性表的长度
    public int length(){
        return N;
    }

    //获取指定位置的元素
    public T get(int i){
        return eles[i];
    }

    //向线性表中添加元素t
    public void insert(T t){
        //N初始值0,添加元素t后,N自增1
        eles[N++] = t;
    }

    //在i索引处插入元素t
    public void insert(int i,T t){
        //先把i索引处及之后的元素向后依次移动一位
        for (int index =N-1;index >i;index--){
            eles[index] = eles[index-1];
        }
        //再把t元素放到i索引处即可
        eles[i] =t;
    }

    //删除并返回线性表中第i个数据元素
    public T remove(int i){
        //记录索引i处的值
        T current = eles[i];
        //索引i后的元素依次向前移动一位
        for (int index =i;index < N-1;index++){
            eles[index] = eles[index+1];
        }
        //元素个数-1
        N--;
        return current;
    }

    //返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返回-1
    public int indexOf(T t){
        for (int i =0;i <N;i++){
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
