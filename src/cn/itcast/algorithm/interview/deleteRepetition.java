package cn.itcast.algorithm.interview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class deleteRepetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String string = sc.nextLine();
            HashSet<Character> set = new HashSet<>();
            for (int i =0;i < string.length();i++){
                char c = string.charAt(i);
                if(set.add(c)){
                    System.out.print(c);
                }
            }

        }

    }

}
