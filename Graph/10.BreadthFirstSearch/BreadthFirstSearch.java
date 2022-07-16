import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

//bfs exapands on basis of radius. say, first it will give all node at distance 1, next at distance 2, next at distance 3 and so on...
public class BreadthFirstSearch {
    
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
        Queue<Pair>  queue = new ArrayDeque<>();
        queue.add(new Pair(2, 2+" "));
        //4steps : remove , mark*, work, add*
        while(queue.size() > 0){
            Pair rem = queue.remove();

            if(visited[rem.sc] == true){
                continue;
            }

            visited[rem.sc] = true;
            System.out.println(rem.sc + " @ "+ rem.psf);
            for(Edge edge : graph[rem.sc]){
                if(visited[edge.dest] == false){
                    queue.add(new Pair(edge.dest, rem.psf+edge.dest+" "));
                }
            }
            
        }
        
    }

}
