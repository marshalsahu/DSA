import java.util.ArrayList;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//Hamiltonian path is the path that connects every vertices present in the graph.
//Hamiltonian cycle is the cycle where every grpah node is visited once and there is an edge from last node to start node.
public class HamiltonianPath {
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
            graph[v2].add(new Edge(v2, v1));
        }

      HashSet<Integer> visited = new HashSet<>();
        getHamiltonianPath(graph, 0, visited, 0+" ", 0);
        
    }

    public static void getHamiltonianPath(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String asf, int osrc){

        if(visited.size() == graph.length-1){
            System.out.print(asf);
            boolean isCycle = false;
            for(Edge edge :graph[src]){
                if( edge.dest == osrc){
                    isCycle = true;
                    break;
                }
            }

            if(isCycle == true){
                System.out.print("*");
            }else{
                System.out.println(".");
            }
        }
        
        visited.add(src);
        for(Edge edge : graph[src]){
            if(visited.contains(edge.dest) == false){
                getHamiltonianPath(graph, edge.dest, visited, asf+edge.dest+" ", osrc);
            }
        }
        visited.remove(src);
    }
}
