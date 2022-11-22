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
        return find(p) == find(q);
    }

    //元素p所在分组的标识符
    /**1.判断当前元素p的父节点eleAndGroup[p]是不是自己，如果是自己则说明已经是根节点了
     * 2.如果当前元素p的父节点不是自己，则让p=eleAndGroup[p],继续寻找父节点的父节点，直到找到根节点为止
     **/
    public int find(int p){
        while (true){
            if (p == eleAndGroup[p]){
                return p;
            }
            p =  eleAndGroup[p];
        }
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p,int q){
        //找到p和q的根节点
        int pRoot = find(p);
        int qRoot = find(q);

        //如果p和q已经在同一分组中，则无需合并
        if (pRoot == qRoot){
            return;
        }

        //让p所在树根节点的父节点等于q的父节点
        eleAndGroup[p] = qRoot;

        //组的数量-1
        this.count--;
    }
}
