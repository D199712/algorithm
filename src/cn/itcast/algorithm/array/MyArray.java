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

        if (size >= array.length){
            resize();
        }

        System.out.println("初始SIZE："+size);
        //从右向左循环，将元素逐个向右移一位
        for (int i = size-1; i>=index; i--){
            System.out.println("本次循环元素下标："+i);
            array[i+1] = array[i];
        }
        //腾出的位置放入新元素
        array[index] = element;
        size++;
        System.out.println("最终SIZE:"+size);
        System.out.println("!!!!!!!!!!!!!!!");
    }

    /**
     * 数组扩容
     */
    public void resize(){
        int [] arrayNew = new int[array.length*2];
        //从旧数组复制到新数组
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
        System.out.println("数组扩容");
    }

    /**
     * 数组删除元素
     * @param index
     * @return
     * @throws Exception
     */
    public int delete(int index) throws Exception{
        //判断访问下标是否超出范围
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }

        int deleteElement = array[index];
        //从左向右循环，将元素逐个向左挪移一位
        for (int i = index; i<size;i++){
            array[i] = array[i+1];
        }
        size--;
        System.out.println("删除节点："+index+",节点值："+deleteElement);
        return deleteElement;
    }

    /**
     * 输出数组
     */
    public void output(){
        for (int i=0; i <= size; i++){
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        MyArray myArray = new MyArray(4);
        myArray.insert(3,0);
        myArray.insert(7,1);
        myArray.insert(9,2);
        myArray.insert(5,3);
        myArray.insert(4,1);
//        myArray.insert(4,7);
        myArray.delete(3);
        myArray.output();
    }
}
