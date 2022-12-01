package cn.itcast.algorithm.test;

import cn.itcast.algorithm.UF.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Description //TODO
 * @Date 2022/12/1 23:39
 * @Author DJ
 *畅通工程
 * trffic_project.txt文件
 * 20个城市，目前已经修改好了7条道路，问还需要修建多少条道路，才能让这20个城市之间全部相通？
 * 解题思路：
 * 1.创建一个并查集UF_Tree_Weighted(20);
 * 2.分别调用union(0,1),union(6,9),union(3,8),union(5,11),union(2,12),union(6,10),union(4,8)，表示已经修建好的
 * 道路把对应的城市连接起来；
 * 3.如果城市全部连接起来，那么并查集中剩余的分组数目为1，所有的城市都在一个树中，所以，只需要获取当前
 * 并查集中剩余的数目，减去1，就是还需要修建的道路数目；
 **/
public class Traffic_Project_Test {
    public static void main(String[] args) throws Exception{
        //创建一个缓冲读取流BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(Traffic_Project_Test.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        //读取第一行数据20
        int totalNumber = Integer.parseInt(reader.readLine());
        //构建一个并查集对象
        UF_Tree_Weighted uf = new UF_Tree_Weighted(totalNumber);
        //读取第二行数据7
        int roadNumber = Integer.parseInt(reader.readLine());
        //循环读取7条道路
        for (int i = 0; i < roadNumber; i++){
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            //调用并查集对象的union方法让两个城市相通
            uf.union(p,q);
        }


        //获取当前并查集分组数量 -1
        int roads = uf.count();
        System.out.println("需要"+(roads-1)+"条道路");
    }
}
