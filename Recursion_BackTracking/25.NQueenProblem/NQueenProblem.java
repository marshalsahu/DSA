import java.util.Scanner;
//level and options
//level usually gets kept in function parameter
//options are no of calls we are making inside function
public class NQueenProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        solution(chess, "", 0);
        sc.close();
    }
    
    public static void solution(int[][] chess, String asf, int row){

        if(row == chess.length){
            System.out.println(asf+".");
            return;
        }
         
        for(int col = 0 ; col < chess.length; col++){
             if (isItSafePlaceForQueen(chess,row,col)) {
                chess[row][col] = 1;
            solution(chess, asf+row+"-"+col+",", row+1);
            chess[row][col] = 0;
            }
        }

    }

    public static boolean isItSafePlaceForQueen(int[][] chess, int row, int col){

        for(int i=row-1, j=col; i>=0; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i=row-1,j=col-1; i >= 0 && j >= 0; i-- , j--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i=row-1,j=col+1; i >= 0 && j < chess.length; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }

        return true;
    }
}
