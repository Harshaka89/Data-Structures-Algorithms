/*  DESCRIPTION:  Implementation of a BFS in java
*/
import java.util.*;

public class BreadthFirstSearch {
	private boolean[] marked;
	
	public BreadthFirstSearch(Graph g, int s){
		marked = new boolean[g.getV()];
		bfs(g, s);
	}
	private void bfs(Graph g, int s){
		Queue<Integer> queue = new LinkedList<Integer>();
		marked[s] = true;
		queue.add(s);
		while(!queue.isEmpty()){
			int v = queue.remove();
			System.out.print(v + " ");
			for(int w : g.adj(v)){
				if(!marked[w]){
					marked[w] = true;
					queue.add(w);
				}
			}
		}	
	}
	/*Will return true if there is a path between the source vertex "s" and vertex "v" and false otherwise */
	public boolean marked(int v){
		return marked[v];
	}
}
