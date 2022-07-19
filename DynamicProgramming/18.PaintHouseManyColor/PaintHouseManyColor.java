import java.util.*;

public class PaintHouseManyColor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[n][c];

        for(int i=0; i<n; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][c];

        //Aproach 1 : O(n^3)    

        // for(int j=0; j<dp[0].length; j++){
        //     dp[0][j] = arr[0][j];
        // }

   
        // for(int i=1; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         int min = Integer.MAX_VALUE;

        //         for(int k=0; k<dp[0].length; k++){
        //             if(j != k){
        //                 if(dp[i-1][k] < min){
        //                     min = dp[i-1][k];
        //                 }
        //             }
        //         }

        //         dp[i][j] = arr[i][j]+min;
        //     }
        // }

        // int min = Integer.MAX_VALUE;
        // for(int k=0; k<dp[0].length; k++){
           
        //     if(dp[n-1][k] < min){
        //         min = dp[n-1][k];
        //     }
            
        // }


        //Approach 2
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = arr[0][j];

            if(arr[0][j] <= least){
                sleast = least;
                least = arr[0][j];
            }else if(arr[0][j] <= sleast){
                sleast = arr[0][j];
            }
        }


        for(int i=1; i<dp.length; i++){
            int nleast = Integer.MAX_VALUE;
            int nSleast = Integer.MAX_VALUE;

            for(int j=0; j<dp[0].length; j++){
                if(least == dp[i-1][j]){
                    dp[i][j] = sleast + arr[i][j];
                }else{
                    dp[i][j] = least + arr[i][j];
                }

                if( dp[i][j] <= nleast ){
                    nSleast = nleast;
                    nleast = dp[i][j];
                }else if(dp[i][j] <= nSleast){
                    nSleast = dp[i][j];
                }
                
            }
            least = nleast;
            sleast = nSleast;
        }

        System.out.println(least);
    }    
}
