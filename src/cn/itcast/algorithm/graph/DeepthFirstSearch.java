package cn.itcast.algorithm.graph;

/**
 * @Description //TODO
 * @Date 2023/1/13 0:42
 * @Author DJ
 **/
public class DeepthFirstSearch {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;

    //记录有多少个顶点与S顶点相通
    private int count;

    //构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点
    public DeepthFirstSearch(Graph G, int s) {
        /**为了不对顶点进行重复搜索，应该要有相应的标记来表示当前顶点有没有搜索过，可以使用一个布
        尔类型的数组 boolean[V] marked,索引代表顶点，值代表当前顶点是否已经搜索，如果已经搜索，标记为true，
        如果没有搜索，标记为false；**/
        //创建一个和图的顶点数一样大小的布尔数组
        marked = new boolean[G.V()];

        //初始化顶点S相通的顶点的数量
        this.count = 0;

        dfs(G,s);
    }

    //使用深度优先搜索找出G图中顶点的所有相邻顶点
    public void dfs(Graph G,int v){
        //把当前顶点定义为已搜索
        marked[v] = true;
        //遍历v顶点的邻接表，得到每一个顶点w
        for (Integer w: G.adj(v)) {
            //如果当前顶点w没被搜索过，则递归搜索与w顶点相通的其他顶点
            if (!marked[w]){
                dfs(G,w);
            }
        }
        //相通的顶点数量+1
        count++;
    }

    //判断w顶点是否与S顶点相通
    public boolean marked(int w){
        return marked[w];
    }

    //获取与顶点S相通的所有顶点的总数
    public int count(){
        return count;
    }
}
