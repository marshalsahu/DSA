import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DijkstraAlgo {
    public static class Edge{
        int sc;
        int dest;
        int wt;
        public Edge(int sc, int dest, int wt){
            this.sc = sc;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int v;
        String psf;
        int wsf;

        public Pair(int v, String psf, int wsf){
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        int src = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Pair> q = new PriorityQueue<>();  
        q.add(new Pair(src, src+"", 0));

        while(q.size() > 0){
            Pair rem = q.remove();

            if(visited[rem.v] == true){
                continue;
            }

            visited[rem.v] = true;

            System.out.println(rem.v+"@"+rem.psf+"@"+rem.wsf);

            for(Edge e : graph[rem.v]){
                if(visited[e.dest] == false){
                    q.add(new Pair(e.dest, rem.psf+e.dest+"", rem.wsf+e.wt));
                }
            }
        }

    }
}

//test case
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 20
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8