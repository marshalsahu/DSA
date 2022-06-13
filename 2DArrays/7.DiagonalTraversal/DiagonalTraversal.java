import java.util.Scanner;

public class DiagonalTraversal {
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
        //display function
        System.out.println("Given matrix");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        //upper Diagonal traversal

        for(int g=0; g < arr.length; g++){
            for(int i=0,j=g; j < arr[0].length ; i++,j++){
                System.out.print(arr[i][j]+ " ");
            }
        }

        sc.close();

    }
}
