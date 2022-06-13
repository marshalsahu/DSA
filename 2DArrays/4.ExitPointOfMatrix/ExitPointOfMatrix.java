import java.util.Scanner;


//consider this array a maze, a player enter from top-left corner in east direction.   
//the player moves in the east direction as long as he meets '0'. On seeing '1', he takes a 90deg right turn.
//you are requested to print the indices in (row,col) format of the point from where you exit the matrix.

public class ExitPointOfMatrix {
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

        //Exit point of matrix.
        int dir = 0; // 0 - east, 1 - south, 2 - west, 3 - North
        int i=0;
        int j=0;

        while(true){

            dir = (dir + arr[i][j])%4;

            if(dir == 0){ //east
                j++;
            }else if(dir == 1){ //south
                i++;
            }else if(dir == 2){ //west
                j--;
            }else if(dir == 3){ //north
                i--;
            }

            if( i < 0){
                i++;
                break;
            }else if(j < 0){
                j++;
                break;
            }else if( i == arr.length){
                i--;
                break;
            }else if( j == arr[0].length){
                j--;
                break;
            }
        }
        System.out.println("result position is "+i+" ---> "+j);
        sc.close();
    }
}
