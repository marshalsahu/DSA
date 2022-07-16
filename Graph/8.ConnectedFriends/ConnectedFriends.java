import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConnectedFriends {

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

        boolean[] visited = new boolean[vertices];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int i=0; i< vertices; i++){
            if(visited[i] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                getComponents(graph, i, visited, comp);
                comps.add(comp);
            }
        }
        
        int pairs = 0;
        for(int i=0; i<comps.size(); i++){
            for(int j=i+1; j<comps.size(); j++){
                int count = comps.get(i).size() * comps.get(j).size();
                pairs += count;
            }
        }

        System.out.println("total pair is "+pairs);
    }

    public static void getComponents(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp){

        comp.add(src);
        visited[src] = true;
        for( Edge edge : graph[src]){
            if(visited[edge.dest] == false){
                getComponents(graph, edge.dest, visited, comp);
            }
        }
    }
}
