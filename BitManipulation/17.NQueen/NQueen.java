
import java.util.Scanner;

public class NQueen {
    public static void display(int[][] arr){
        for(int i=0; i< arr.length; i++){
            for(int j=0; j< arr.length; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void solveNQueen(int[][] arr,int column, int normalDiagonal, int reverseDiagonal, int row){

        if(row == arr.length){
            System.out.println(" result is ");
            display(arr);
            return;
        }

        for(int col=0; col < arr.length; col++){
          
            if( ((column & (1 << col))== 0) &&
                ((normalDiagonal & (1 << (row+ col)))== 0) &&
                ((reverseDiagonal & (1 << (row -col + arr.length - 1))) == 0)
                ){
                    arr[row][col] = 1;
                    column ^= (1 << col);
                    normalDiagonal ^= (1 << (row+col));
                    reverseDiagonal ^= (1 << (row - col + arr.length - 1));
                    solveNQueen(arr, column, normalDiagonal, reverseDiagonal, row+1);
                    reverseDiagonal ^= (1 << (row - col + arr.length - 1));
                    normalDiagonal ^= (1 << (row+col));
                    column ^= (1 << col);
                    arr[row][col] = 0;
                }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int column = 0;
        int normalDiagonal = 0;
        int reverseDiagonal = 0;
        int[][] arr = new int[n][n];
        solveNQueen(arr, column, normalDiagonal, reverseDiagonal, 0);
        sc.close();
    }
}
