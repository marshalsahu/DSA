import java.util.Scanner;

public class KnightsTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] chess = new int[n][n];
        solution(chess,r,c,1);
        sc.close();
    }

    public static void display(int[][] chess){
        for(int i=0; i < chess.length; i++){
            for(int j=0; j < chess.length; j++){
                System.out.print(chess[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void solution(int[][] chess, int row, int col, int move){


        if( row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0){
            return;
        }else if( move == chess.length * chess.length){
            chess[row][col] = move;
            System.out.println("solution found is ------> ");
            display(chess);
            System.out.println();
            System.out.println();
            chess[row][col] = 0;
        }

        chess[row][col] = move;
        solution(chess, row-2, col+1, move+1);
        solution(chess, row-1, col+2, move+1);
        solution(chess, row+1, col+2, move+1);
        solution(chess, row+2, col+1, move+1);
        solution(chess, row+2, col-1, move+1);
        solution(chess, row+1, col-2, move+1);
        solution(chess, row-1, col-2, move+1);
        solution(chess, row-2, col-1, move+1);
        chess[row][col] = 0;
    }
}
