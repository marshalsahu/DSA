import java.util.*;
public class CoinChangePermutation {
    
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();
        int[] coins = new int[m];
        
        for(int i=0; i<coins.length; i++){
            coins[i] = sc.nextInt();
        }
        int tar = sc.nextInt();

        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int amt = 1; amt < dp.length; amt++){
            for(int coin : coins){
                if (amt >= coin){
                    dp[amt] += dp[amt-coin];
                }
            }
        }

        System.out.println(dp[tar]);
    }
}
