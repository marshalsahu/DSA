import java.util.Scanner;

public class CountIslandGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[row][col];
        int count =0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(arr[i][j] ==0 && visited[i][j] == false){
                    getIsland(arr,i,j,visited);
                    count++;
                }
                
            }
        }
        System.out.println("total island is "+count);
    }

    public static void getIsland(int[][] arr, int i, int j, boolean[][] visited){
        if( i<0 || j<0 || i>=arr.length || j>=arr[0].length ||
            arr[i][j]==1 || visited[i][j]==true){
                return;
        }

        visited[i][j] = true;
        getIsland(arr,i-1,j,visited);
        getIsland(arr,i,j+1,visited);
        getIsland(arr,i,j-1,visited);
        getIsland(arr,i+1,j,visited);
    }
    
}
