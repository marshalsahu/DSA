import java.util.*;
public class BuyAndSellKTransactionsAllowed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prices = new int[n];
        for(int i=0; i<prices.length; i++){
            prices[i] = sc.nextInt();
        }
        int k = sc.nextInt(); //allowed transactions

        int[][] dp = new int[k+1][prices.length];
        //bad approach as O(n^3)
        // for(int t = 1; t <= k; t++){
        //     for(int d = 1; d < prices.length; d++){
        //         int max= dp[t][d-1];

        //         for(int pd=0; pd<d; pd++){
        //             int ptilltm1 = dp[t-1][pd];
        //             int ptth = prices[d] - prices[pd]; //profit at Tth transaction
                    
        //             if( ptth + ptilltm1 > max){
        //                 max = ptilltm1 + ptth;
        //             }
        //         }

        //         dp[t][d] = max;
        //     }
        // }

        //good apporach/ optimized approach
   
        for(int t = 1; t <= k; t++){
            int max= Integer.MIN_VALUE;
            for(int d = 1; d < prices.length; d++){
                
                if (dp[t-1][d-1] - prices[d-1] > max){
                    max = dp[t-1][d-1] - prices[d-1];
                }

                if (max + prices[d] > dp[t][d-1]){
                    dp[t][d] = max + prices[d];
                }else{
                    dp[t][d] = dp[t][d-1];
                }
               
            }
        }
        System.out.println(dp[k][prices.length-1]);
    }

}
