package cn.itcast.algorithm.array;

/**
 * @Author DJ
 * @Description //TODO $end$
 * @Date $time$ $date$
 * @return $return$
 */
public class MyArray {

    private int[] array;
    private int size;

    /**
     * 构造方法
     * @param capacity
     */
    public MyArray(int capacity){
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 数组插入元素
     * @param element 插入的元素
     * @param index    插入的位置
     * @throws Exception
     */
    public void insert(int element,int index) throws Exception{
        //判断访问下标是否超出范围
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }

        //从右向左循环，将元素逐个向右移一位
        for (int i = size-1; i>=i;i--){
            array[i+1] = array[index];
        }
        //腾出的位置放入新元素
        array[index] = element;
        size++;
    }

    /**
     * 输出数组
     */
    public void output(){
        for (int i=0; i <= size; i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        MyArray myArray = new MyArray(10);
        myArray.insert(3,0);
        myArray.insert(9,2);
        myArray.insert(5,3);
        myArray.insert(7,3);
        myArray.output();
    }
}
