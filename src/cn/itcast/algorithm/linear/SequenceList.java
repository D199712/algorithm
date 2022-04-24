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
        if (N==eles.length){
            resize(2*eles.length);
        }
        //先把i索引处及之后的元素向后依次移动一位
        for (int index = N;index >i;index--){
            eles[index] = eles[index-1];
        }
        //再把t元素放到i索引处即可
        eles[i] =t;
        //元素个数+1
        N++;
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

        if (N<eles.length/4){
            resize(eles.length/2);
        }
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

    //顺序表容量可变
    public void resize(int newSize){
        //定义临时数组，指向原数组
        T[] temp = eles;
        //创建新数组
        eles = (T[])new Object[newSize];
        //把原数组拷贝到新数组
        for (int i=0;i<N;i++){
            eles[i] =temp[i];
        }
     }
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int cursor;

        public SIterator(){
            this.cursor=0;
        }
        @Override
        public boolean hasNext() {
            return cursor<N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }
}
