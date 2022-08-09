import java.util.ArrayList;
import java.util.Scanner;

public class GoldMineII {

    public static void travelAndCollectCoin(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> bag){

        if( i < 0 || i >= arr.length || j < 0 || j >= arr.length || visited[i][j] == true || arr[i][j] == 0){
            return;
        }
        visited[i][j] = true;
        bag.add(arr[i][j]);
        travelAndCollectCoin(arr, i-1, j, visited, bag);
        travelAndCollectCoin(arr, i, j+1, visited, bag);
        travelAndCollectCoin(arr, i, j-1, visited, bag);
        travelAndCollectCoin(arr, i+1, j, visited, bag);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        int maxSum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
               if(arr[i][j] != 0 && visited[i][j] == false){
                    ArrayList<Integer> bag = new ArrayList<>();
                    travelAndCollectCoin(arr,i,j,visited,bag);
                        int bagValue =0;
                    for(int val: bag){
                            bagValue += val;
                    }

                    if( bagValue > maxSum){
                        maxSum = bagValue;
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}
