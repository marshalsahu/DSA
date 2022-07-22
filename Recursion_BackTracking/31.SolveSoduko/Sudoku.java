import java.util.Scanner;

public class Sudoku {

    public static void display(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isValid(int[][] arr, int x, int y, int val){

        //checkig in row
        for(int i=0; i<arr.length; i++){
            if(arr[i][y] == val){
                return false;
            }
        }

        //checking in column
        for(int j=0; j<arr[0].length; j++){
            if(arr[x][j] == val){
                return false;
            }
        }
        //checkingfor submatrix
        int smi = x / 3 * 3;
        int smj = y / 3 * 3;
        for(int i=0; i<3 ; i++){
            for(int j=0; j<3; j++){
                if(arr[smi+i][smj+j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    public static void solveSudoku(int[][] arr, int i, int j){
        if(i == arr.length){
            display(arr);
            return;
        }
        int ni = 0;
        int nj = 0;
        if(j == arr[0].length-1){
            ni = i+1;
            nj = 0;
        }else{
            ni = i;
            nj = j+1;
        }

        if(arr[i][j] != 0){
            solveSudoku(arr, ni, nj);
        }else{
            for(int po=1; po<=9; po++){
                if(isValid(arr,i,j, po) == true){
                    arr[i][j] = po;
                    solveSudoku(arr, ni, nj);
                    arr[i][j] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        solveSudoku(arr,0,0);
    }
}
