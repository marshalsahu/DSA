import java.util.ArrayList;
import java.util.Scanner;

public class GoldMine {
    
    static int max = 0;

    public static void travelAndCollectGold(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> bag){

        if(i < 0 || j < 0 || i >= arr.length || j>= arr[0].length || arr[i][j] == 0 || visited[i][j] == true){
            return;
        }

        visited[i][j] = true;
        bag.add(arr[i][j]);
        travelAndCollectGold(arr, i-1, j, visited, bag);
        travelAndCollectGold(arr, i, j+1, visited, bag);
        travelAndCollectGold(arr, i, j-1, visited, bag);
        travelAndCollectGold(arr, i+1, j, visited, bag);
        
    }

    public static void getMaxGold(int[][] arr){
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                
                if(arr[i][j] != 0 && visited[i][j] == false){
                    ArrayList<Integer> bag = new ArrayList<>();
                    travelAndCollectGold(arr, i, j, visited, bag);
                    int sum=0;
                    for(int coin: bag){
                        sum+=coin;
                    }

                    if(sum > max){
                        max = sum;
                    }
                }
            }
        }
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

        getMaxGold(arr);
        System.out.println(max);
    }
}
