import java.util.Scanner;
import java.util.*;
public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int ts = countPath(n);
        System.out.println("total steps "+ ts);
        int totalSteps = countPathUsingMemoization(n, new int[n+1]);
        System.out.println("total steps "+totalSteps);
        int s = countPathUsingTabulization(10);
        System.out.println("total steps "+s);
    }    

    //approach 1 : not recommended.
    public static int countPath(int n){

        if(n == 0){
            return 1;
        }else if( n < 0){
            return 0;
        }

        int pnm1 = countPath(n-1);
        int pnm2 = countPath(n-2);
        int pnm3 = countPath(n-3);
        int tp = pnm1 + pnm2 + pnm3;
        return tp;
    }

    //approach 2 : using memoization
    public static int countPathUsingMemoization(int n, int[] arr){
        if(n == 0){
            return 1;
        }else if( n < 0){
            return 0;
        }
        
        if(arr[n] > 0){
            return arr[n];
        }

        int pnm1 = countPath(n-1);
        int pnm2 = countPath(n-2);
        int pnm3 = countPath(n-3);
        int tp = pnm1 + pnm2 + pnm3;
        arr[n] = tp;
        return tp;
    }
    //tabulization method
    //storage and meaning, Identify Direction(<>), Travel and Solve
    public static int countPathUsingTabulization(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n ; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }else if(i == 2){
                dp[i] = dp[i-1]+dp[i-2];
            }else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        return dp[n];
    }
}
