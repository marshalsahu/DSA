import java.util.*;

public class GoldMineMaximum {

    //storae and meaning
    //Direction
    //travel and solve
    //each cell stores info of how much maximum gold it can collect from that cell towards its right.
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[m][n];
        for(int j = arr[0].length -1; j>=0; j--){
            for(int i = arr.length-1; i>=0 ; i--){
                
                if( j == arr[0].length-1){
                    dp[i][j] = arr[i][j];
                }else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], arr[i+1][j+1]);
                }else if(i == arr.length-1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], arr[i-1][j+1]);
                }else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], Math.max(arr[i-1][j+1], arr[i+1][j+1]));
                }
            }
        }
        int max = dp[0][0];
        for(int i=1; i<dp.length; i++){
            if(dp[i][0] > max){
                max = dp[i][0];
            }
        }
        System.out.println(max);
    }
}
