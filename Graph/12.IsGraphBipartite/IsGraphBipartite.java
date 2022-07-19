import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IsGraphBipartite {
    //A Graph is said to be bipartite if it is possible to divide vertices into 
    //2 mutually exclusive and exhaustive sets such that all edges are across sets.

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
        int level;

        public Pair(int sc, String psf, int level){
            this.sc = sc;
            this.psf = psf;
            this.level = level;
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

        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);
        for(int i=0; i<vertices; i++){
            if(visited[i] == -1){
                boolean isBipartitie = checkComponentForBipartiteness(graph,i,visited);
                if(isBipartitie == false){
                    System.out.println("not bipartitie");
                    return;
                }
            }
        }
        System.out.println("is bipartite");
    }
        //algorithm : 4 steps: remove , mark*, work, add*
    public static boolean checkComponentForBipartiteness(ArrayList<Edge>[] graph, int src, int[] visited){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src+"", 0));

        while(q.size()> 0){
            Pair rem = q.remove();

            if(visited[rem.sc] != -1){
                if(rem.level != visited[rem.sc]){
                    return false;
                }
            }

            visited[rem.sc] = rem.level;

            for( Edge e : graph[rem.sc]){
                if(visited[e.dest] == -1){
                    q.add(new Pair(e.dest, rem.psf+e.dest, rem.level+1));
                }
            }
             
        }
        return true;
    }

   
}
