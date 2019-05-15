package graph;
/**
 * 连通分量
 * @author zhang
 *
 */
public class Components {
	private Graph g;
	private int ccount;
	private boolean[] visited;
	private int[] id;
	public Components() {
		
	}
	//深度优先遍历
	private void dfs(int n){
		visited[n]=true;
		id[n]=ccount;
		for (Integer i : g.adj(n)) {
			if(!visited[i]){
				dfs(i);
			}
		}
	}
	public Components(Graph g) {
		this.g = g;
		ccount=0;
		visited=new boolean[g.V()];
		id=new int[g.V()];
		for(int i=0;i<g.V();i++){
			visited[i]=false;
			id[i]=-1;
		}
		//求图的连通分量
		for(int i=0;i<g.V();i++){
			if(!visited[i]){
				dfs(i);
				ccount++;
			}
		}
	}
	//返回连通分量
	public int getCount(){
		return ccount;
	}
	//查询v和m之间是否连通
	public boolean isConnected(int v,int m){
		if(v<0||v>=g.V()){
			throw new IllegalArgumentException("越界");
		}
		if(m<0||m>=g.V()){
			throw new IllegalArgumentException("越界");
		}
		return id[v]==id[m];
	} 
	
}
