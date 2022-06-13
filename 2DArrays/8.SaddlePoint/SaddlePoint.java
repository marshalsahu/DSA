import java.util.Scanner;

//saddle point is the point where num is min in its row but max in its column.
public class SaddlePoint {
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


        //saddle point
        for(int i=0; i<arr.length; i++){
            int mc = 0;
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] < arr[i][mc]){
                    mc = j;
                }
            }

            boolean flag = true;
            for(int k=0; k<arr.length; k++){
                if(arr[k][mc] > arr[i][mc]){
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                System.out.println("saddle point is "+ arr[i][mc]);
                return;
            }
        }
        System.out.println("No saddle point");



        sc.close();
    }
}
