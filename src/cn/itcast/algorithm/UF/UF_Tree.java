package cn.itcast.algorithm.UF;

/**
 *
 */
public class UF_Tree {
    //记录节点元素或者该元素父节点
    private int[] eleAndGroup;
    //获取当前并查集中的数据有多少个分组
    private int count;

    public UF_Tree(int N){
        this.count = N;
        this.eleAndGroup = new int[N];

        for (int i = 0; i < N;i++){
            eleAndGroup[i] = i;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count(){
        return count;
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p,int q){
        return false;
    }

    //元素p所在分组的标识符
    public int find(int p){
        return -1;
    }

    //把p元素所在分组和q元素所在分组合并
    public void unio(int p,int q){

    }
}
