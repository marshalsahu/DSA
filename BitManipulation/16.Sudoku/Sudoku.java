
import java.util.Scanner;

//complete sudoku
public class Sudoku {
    public static void display(int[][] arr){
        for(int ii=0; ii < arr.length; ii++){
            for(int jj=0; jj < arr[0].length; jj++){
                System.out.print(arr[ii][jj]+"  ");
            }
            System.out.println();
        }
    }
    public static void solve(int[][] arr, int[] rows, int[] cols,int[][] grid, int i, int j, int count){
        if( i == arr.length){
            count+=1;
            display(arr);
            System.out.println("count is "+ count);
            return;
        }

        if(arr[i][j] > 0){
            solve(arr, rows, cols, grid, j == arr[0].length-1 ? i+1: i, j==arr[0].length-1 ? 0: j+1, count);
        }else{
            for(int num=1 ; num <= 9; num++){
                if( (rows[i] & (1 << num))==0 &&
                     (cols[j] & (1 << num))==0 &&
                     (grid[i/3][j/3] & (1 << num)) == 0 ){
                        arr[i][j] = num;
                        rows[i] ^= (1 << num);
                        cols[j] ^= (1 << num);
                        grid[i/3][j/3] ^= ( 1 << num);
                        solve(arr, rows, cols, grid, j == arr[0].length-1 ? i+1: i, j==arr[0].length-1 ? 0: j+1, count);
                        grid[i/3][j/3] ^= ( 1 << num);
                        cols[j] ^= (1 << num);
                        rows[i] ^= (1 << num);
                        arr[i][j] = 0;
                    }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[9][9];
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] grid = new int[3][3];

        for(int i=0; i<arr.length; i++){
            for(int j=0;j<arr[0].length; j++){
                int digit = sc.nextInt();
                arr[i][j] = digit;
                rows[i] |= (1 << digit);
                cols[j] |= (1 << digit);
                grid[i/3][j/3] |= (1 << digit);
            }
        }
        solve(arr,rows, cols, grid, 0, 0, 0);

        
        sc.close();
    }
}
