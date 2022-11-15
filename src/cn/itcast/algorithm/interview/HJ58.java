package cn.itcast.algorithm.interview;

import cn.itcast.algorithm.sort.BubbleSort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ58 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String nk = bf.readLine();
        String[] c = nk.split(" ");
        int n = Integer.parseInt(c[0]);
        int k = Integer.parseInt(c[1]);
        String[] numbers = bf.readLine().split(" ");
        int[] target = new int[n];
        for(int i = 0; i < n; i++){
            target[i] = Integer.parseInt(numbers[i]);
        }
        int[] result = bubbleSort(target);
        for(int z = 0; z < k; z++){
            System.out.print(result[z]);
            System.out.print(" ");
        }
    }

    //冒泡
    public static int[] bubbleSort(int[] array){
        int tmp = 0;
        for (int i = 0; i < array.length -1; i++){
            for (int j = 0; j < array.length -i-1;j++){
                if(array[j] > array[j+1]){
                    tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

}
