import java.util.*;

public class ZeroOneKnapSack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wts = new int[n];
        int[] vals = new int[n];

        for(int i=0; i<n; i++){
            wts[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            vals[i] = sc.nextInt();
        }

        int cap = sc.nextInt();

        int[][] dp = new int[n+1][cap+1];

        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if( j >= wts[i-1]){
                    int remCap = j - wts[i-1];
                    if(dp[i-1][remCap]+vals[i-1] > dp[i-1][j]){
                        dp[i][j] = dp[i-1][remCap]+vals[i-1];
                    }else{
                        dp[i][j] = dp[i-1][j]; //when i bat but score total is less than before.
                    }
                }else{
                    dp[i][j] = dp[i-1][j];  //when i doesn't bat
                }
            }
        }
        System.out.println(dp[wts.length][cap]);
    }
}
