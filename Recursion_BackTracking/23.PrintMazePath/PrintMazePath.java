import java.util.Scanner;

public class PrintMazePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];

        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[row][col];
       
        solution(arr,0,0,"",visited);
    }

    public static void solution(int[][] maze, int row, int col, String asf, boolean[][] visited){

        

        if( row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col] == true){
            return;
        }

        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(asf);
            return ;
        }

        visited[row][col] = true;
        solution(maze, row-1, col, asf+"t", visited);
        solution(maze, row, col-1, asf+"l", visited);
        solution(maze, row+1, col, asf+"d", visited);
        solution(maze, row, col+1, asf+"r", visited);
        visited[row][col] = false;
    }
}
