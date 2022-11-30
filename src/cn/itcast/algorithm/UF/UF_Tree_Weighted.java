package cn.itcast.algorithm.UF;

/**
 * 路径压缩
 * 把并查集中每一棵树大小记录下来，在每次合并树的时候，把较小的树连接到较大的树上，减小树的深度
 */
public class UF_Tree_Weighted {

    //记录结点元素和该元素的父结点
    private int[] eleAndGroup;

    //存储每个根结点对应的树中元素的个数
    private int[] sz;

    //记录并查集中数据的分组个数
    private int count;

    public UF_Tree_Weighted(int N){
        this.eleAndGroup = new int[N];
        this.count = N;
        this.sz = new int[N];

        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }

        //默认情况下，每个节点都是一个独立的树，每个树中只有一个元素
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
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

        while (true){
            if (p == eleAndGroup[p]){
                return p;
            }
            p = eleAndGroup[p];
        }
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p,int q){

        int pRoot = find(p);
        int qRoot = find(q);

        //判断是否在同一分组，在同一组不需要合并
        if (pRoot == qRoot){
            return;
        }

        //判断pRoot和qRoot谁对应树更高，把低的树合并到高的树
        if (sz[pRoot] > sz[qRoot]){
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }else {
            eleAndGroup[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        
        this.count--;
    }
}
