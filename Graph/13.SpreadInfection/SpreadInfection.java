import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpreadInfection {
    
    public static class Edge{
        int sc;
        int dest;
        public Edge(int sc, int dest){
            this.sc = sc;
            this.dest = dest;
        }
    }

    public static class Pair{
        int v;
        int time;

        public Pair(int v,int time){
            this.v = v;
            this.time = time;
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

        int src = Integer.parseInt(br.readLine());
        int time = Integer.parseInt(br.readLine());
       

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 1));
        int[] visited = new int[vertices];
        int count=0;
        while(q.size() > 0){
            Pair rem = q.remove();

            if( visited[rem.v] > 0){
                continue;
            }

            visited[rem.v] = rem.time;
            if(rem.time > time){
                break;
            }
            count++;

            for(Edge e : graph[rem.v]){
                if(visited[e.dest]==0){
                    q.add(new Pair(e.dest, rem.time+1));
                }
            }
        }
        System.out.println(count);
        //algorithm : 4 steps: remove , mark*, work, add*
    }

    
}