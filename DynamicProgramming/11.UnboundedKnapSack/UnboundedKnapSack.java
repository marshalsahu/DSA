import java.util.*;
public class UnboundedKnapSack {
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
        int[] dp = new int[cap+1];

        dp[0] = 0;
        for(int c=1; c<dp.length; c++){
            int max = 0;
            for(int i=0; i<n; i++){
                

                if(c >= wts[i]){
                    int remCap = c - wts[i];
                    int rembagValue = dp[remCap];
                    int totalbagValue = rembagValue + vals[i];

                    if(totalbagValue > max){
                        max = totalbagValue;
                    }
                }
            }
            dp[c] = max;
        }
        System.out.println(dp[cap]);
    }
}
