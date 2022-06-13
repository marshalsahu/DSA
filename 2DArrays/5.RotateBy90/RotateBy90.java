import java.util.Scanner;

//rotate matrix by 90deg.
// [ 1 4 6 9]            =>    [2 3 2 1]                |  Transpose is :       [1 2 3 2]  => every digit in every row will give ans
// [ 2 5 7 9]                  [6 1 5 4]                |                       [4 5 1 6]
// [ 3 1 4 0]                  [5 4 7 6]                |                       [6 7 4 5]
// [ 2 6 5 2]                  [2 0 9 9]                |                       [9 9 0 2]
public class RotateBy90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];

        for(int i=0; i< row; i++){
            for(int j=0; j< col; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        // in order to solve above problem, we will first take transpose and then reverse digit in every row.
        //Transpose of matrix
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reverse element in row

        for(int i=0; i<arr.length; i++){
            int li = 0;
            int ri = arr[i].length -1 ;

            while(li < ri){
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;
                li++;
                ri--;
            }
        }

        //display
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


        sc.close();
    }
}
