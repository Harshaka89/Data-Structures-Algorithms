/*  DESCRIPTION:  Implementation of an undirected graph in java
*/
import java.util.*;
public class Graph {
	private final int V; // number of vertices
	private int E; //number of edges
	private Stack<Integer>[] adj;
	/*CONSTRUCTOR*/
	public Graph(int V){
		this.V = V;
		this.E = 0;
		adj = new Stack[V]; //Create array of lists
		for(int v = 0; v < V; v++){ //Initialize lists to empty
			adj[v] = new Stack<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	/*Get methods to return number of Vertices and Edges*/
	public int getV(){
		return V;
	}
	public int getE(){
		return E;
	}
	/*Gets the Degree of Vertex*/
	public int degree(int v){
		validateVertex(v);
		return adj[v].size();
	}
	/*Returns a string representation of the graph*/
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " vertices " + E + " edges " + "\n");
		for(int v = 0; v < V; v++){
			s.append(v + ": ");
			for(int w: adj[v]){
				s.append(w + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	/*Returns the vertices adjacent to the vertex*/
	public Iterable<Integer> adj(int v){
		validateVertex(v);
		return adj[v];
	}
	/*Make sure Vertex is valid*/
	private void validateVertex(int v){
		if(v < 0 || v >= V){
			throw new IndexOutOfBoundsException("Vertex: " + v + " is not between 0 and " + (V-1));
		}
	}
}
