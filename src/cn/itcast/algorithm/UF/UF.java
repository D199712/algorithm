package cn.itcast.algorithm.UF;

/**
 *
 */
public class UF {
    //记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //记录并查询集中数据的分组个数
    private int count;

    public UF(int N){
        //初始情况下，每个元素都在一个独立的分组中，所以初始情况下，并查集中的数据分为N个组
        this.count = N;
        //初始化数组
        eleAndGroup = new int[N];
        /*把eleAndGroup数组的索引看作是每个节点存储的元素，把eleAndGroup数组每个
        *索引处值看作是该节点所在的分组，那么初始化情况下，i索引处存储的值就是i
        **/
        for (int i = 0; i < N; i++) {
            eleAndGroup[i] = i;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count(){
        return count;
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    //元素p所在分组的标识符
    public int find(int p){
        return eleAndGroup[p];
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p,int q){
        //判断元素p,q是否在同一分组中，如果已经在同一分组中，结束方法
        if (connected(p,q)){
            return;
        }

        //找到p,q所在分组标识符
        int pGroup = find(p);
        int qGroup = find(q);

        //如果pq不在同一分组，则只需将p元素所在组所有元素标识符修改为q元素所在组标识符
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup){
             eleAndGroup[i] = qGroup;
            }
        }

        //分组数-1
        count--;
    }
}
