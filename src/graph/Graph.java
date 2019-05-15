package graph;

public interface Graph {
	//获得结点的个数
	public int V();
	//获得边的个数
	public int E();
	//向图中添加一条边v-w
	public void addEdge(int v,int w);
	//判断图中两个结点之间是否有边
	public boolean hasEdge(int v,int w);
	//打印图的内容
	public void show();
	//返回图中一个结点的所有邻边
	public Iterable<Integer> adj(int v);
}
