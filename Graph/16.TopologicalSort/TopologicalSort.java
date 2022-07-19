import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//Topological Sort -> A permutation of vertices for a directed acyclic graph is
//  called topological sort if for all directed edges uv, u appears before v in graph.


//order of work is opposite of topological sort
public class TopologicalSort {
    public static class Edge{
        int sc;
        int dest;
        public Edge(int sc, int dest){
            this.sc = sc;
            this.dest = dest;
        }
    }

   

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges; i++){
            String line = br.readLine();
            String[] parts = line.split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
        
            graph[v1].add(new Edge(v1, v2));
        }
        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();

        for(int v=0; v < vertices; v++){
            if(visited[v] == false){
                topologicalSort(graph, v, visited, st);
            }
        }

        while(st.size() > 0){
            System.out.println(st.pop());
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st){

        visited[src] = true;

        for(Edge e: graph[src]){
            if(visited[e.dest]== false){
                topologicalSort(graph, e.dest, visited, st);
            }
        }

        st.push(src);
    }
}
