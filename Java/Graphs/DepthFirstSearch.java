/*  DESCRIPTION:  Implementation of a DFS in java
*/
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	public DepthFirstSearch(Graph g, int s){
		count = 0;
		marked = new boolean[g.getV()];
		dfs(g, s);
	}
	
	private void dfs(Graph g, int v){
		count++;
		marked[v] = true;
		System.out.print(v + " ");
		for(int w : g.adj(v)){
			if(!marked[w]){
				dfs(g, w);
			}
		}
	}
	/*Will return true if there is a path between the source vertex "s" and vertex "v" and false otherwise */
	public boolean marked(int v){
		return marked[v];
	}
	
	/*Returns number of source vertices connected to the source vertex*/
	public int count(){
		return count;
	}
	
}
