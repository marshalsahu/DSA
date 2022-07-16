import java.util.Scanner;

// 2 8 4 1 6 4 2                36 36 30 26 26 35 31 
// 6 0 9 5 3 8 5    =>          34 28 33 25 20 32 29 
// 1 4 3 4 0 6 5                29 28 24 21 17 24 24
// 6 4 7 2 4 6 1                28 25 26 19 17 18 19 
// 1 0 3 7 1 2 7                22 21 21 20 13 12 18 
// 1 5 3 2 3 0 9                24 23 18 15 13 10 11 
// 2 2 5 1 9 8 2                29 27 25 20 19 10 2 
//minimum cost path from from 0,0 to last,last
public class MinimumCostPath {
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

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if( i== dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }else if(i == dp.length-1){
                    dp[i][j] = dp[i][j+1] + arr[i][j];
                }else if(j == dp[0].length-1){
                    dp[i][j] = dp[i+1][j] + arr[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + arr[i][j];
                }
            }
        }

        System.out.println(dp[0][0]);
        display(dp);
    }

    public static void display(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length ; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
