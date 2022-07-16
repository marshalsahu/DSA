import java.util.*;
public class CoinChangeCombination {
    //combination is [(2,2,3),(2,5)]
    //permutation is [(2,2,3),(2,3,2),(3,2,2),(2,5),(5,2)]
    //every cell here represents coount of combination that exist to pay sum = index;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();
        int[] arr = new int[m];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();

        int[] dp = new int[tar+1];
        dp[0] = 1;
        
        for(int i=0; i < arr.length; i++){
            for(int j=arr[i]; j < dp.length; j++){
                dp[j] += dp[ j - arr[i]];
            }
        }

        System.out.println(dp[tar]);
    }
}
