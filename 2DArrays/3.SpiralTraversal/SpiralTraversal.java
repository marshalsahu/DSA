import java.util.Scanner;

public class SpiralTraversal {
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


        //spiral traversal

        int minr = 0;
        int minc = 0;
        int maxr = arr.length -1;
        int maxc = arr[0].length -1;
        int telements = row*col;
        int count = 0;
        while(count < telements){
            //left wall
            for(int i=minr,j=minc; i<= maxr && count < telements; i++ ){
                System.out.print(arr[i][j]+" ");
                count++;
            }
            minc++;

            //bottom wall
            for(int i=maxr,j=minc; j <= maxc && count < telements; j++){
                System.out.print(arr[i][j]+" ");
                count++;
            }
            maxr--;

            //right wall
            for(int i=maxr,j=maxc; i >= minr && count < telements; i--){
                System.out.print(arr[i][j]+" ");
                count++;
            }
            maxc--;
            //top wall
            for(int i=minr,j=maxc; j >= minc && count < telements; j--){
                System.out.print(arr[i][j]+" ");
                count++;
            }
            minr++;
        }


        sc.close();
    }
}
