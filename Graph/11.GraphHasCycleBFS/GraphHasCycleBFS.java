import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class GraphHasCycleBFS {

    public static class Edge{
        int sc;
        int dest;
        public Edge(int sc, int dest){
            this.sc = sc;
            this.dest = dest;
        }
    }

    public static class Pair{
        int sc;
        String psf;

        public Pair(int sc, String psf){
            this.sc = sc;
            this.psf = psf;
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

        boolean[] visited = new boolean[vertices];
        
        for(int i=0; i<vertices; i++){
            if(visited[i] == false){
                boolean containsCycle = hasCycle(graph,i,visited);
                if(containsCycle == true){
                    System.out.println("contains cycle");
                }
            }
        }
        System.out.println("not contains cycle");
    }
    //with the help of 4steps Bfs can be done
    //4steps : remove , mark*, work, add*
    public static boolean hasCycle(ArrayList<Edge>[] graph, int src, boolean[] visited){

        Queue<Pair>  queue = new ArrayDeque<>();
        queue.add(new Pair(src, src+" "));
        
        while(queue.size() > 0){
            Pair rem = queue.remove();

            if(visited[rem.sc] == true){
                return true;
            }

            visited[rem.sc] = true;
            for(Edge edge : graph[rem.sc]){
                if(visited[edge.dest] == false){
                    queue.add(new Pair(edge.dest, rem.psf+edge.dest+" "));
                }
            }
            
        }

        return false;
    }

}
