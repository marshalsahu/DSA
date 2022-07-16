import java.util.PriorityQueue;
import java.util.*;
public class Main {
    //shortestpath,longestpath based on weight
    //floor,ceil based on criteria
    //kth largest path based on weight
    public static class Edge{
        int source;
        int neighbour;
        int weight;

        Edge(int source, int neighbour, int weight){
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int wsf;
        String psf;

        public Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for(int i=0; i < vertices ; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 40));
        

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));


        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        
        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));
        
        boolean[] visited = new boolean[vertices];
        int src= 0;
        solveAll(graph, 0, 6, visited, 40, 3, 0, src+" ");
        System.out.println("solve all function called");
        System.out.println("smallest path is "+spath+"@"+spathWt);
        System.out.println("largest path is "+lpath+"@"+lpathWt);
        System.out.println("floor path is "+fpath+"@"+fpathWt);
        System.out.println("ceil path is "+cpath+"@"+cpathWt);
        System.out.println("kth largest path is "+pq.peek().psf+"@"+pq.peek().wsf);

    }    
    static String spath = "";
    static Integer spathWt = Integer.MAX_VALUE;
    static String lpath = "";
    static Integer lpathWt = Integer.MIN_VALUE;
    static String fpath = "";
    static Integer fpathWt = Integer.MIN_VALUE;
    static String cpath = "";
    static Integer cpathWt = Integer.MAX_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void solveAll(ArrayList<Edge>[] graph, int source, int destination, boolean[] visited, int criteria,int k, int wsf, String asf){
        if(source == destination){
            if(wsf > lpathWt){
                lpathWt = wsf;
                lpath = asf;
            }

            if(wsf < spathWt){
                spathWt = wsf;
                spath = asf;
            }

            if(wsf > criteria && wsf < cpathWt){
                cpathWt = wsf;
                cpath = asf;
            }

            if(wsf < criteria && wsf > fpathWt){
                fpathWt = wsf;
                fpath = asf;
            }

            if(pq.size() < k){
                pq.add(new Pair(wsf, asf));
            }else{
                if(pq.peek().wsf < wsf){
                    pq.remove();
                    pq.add(new Pair(wsf, asf));
                }
            }

            return;
        }
        visited[source] = true;
        for(Edge edge : graph[source]){
            if(visited[edge.neighbour] == false){
                solveAll(graph, edge.neighbour, destination, visited, criteria, k, wsf+edge.weight, asf+edge.neighbour+" ");
            }
        }
        visited[source] = false;

    }
}
