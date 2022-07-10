import java.util.*;

public class PrintAllPath {
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
        
        printAllPath(graph, 0, 6, visited, src+"");

    }    


    public static void printAllPath(ArrayList<Edge>[] graph, int sc, int dest, boolean[] visited, String asf) {
        if( sc == dest){
            System.out.println(asf);
            return;
        }
        visited[sc] = true;
        for(Edge edge : graph[sc]){
            if(visited[edge.neighbour] == false){
                printAllPath(graph, edge.neighbour, dest, visited, asf+edge.neighbour);
            }
        }
        visited[sc] = false;
    }
}
