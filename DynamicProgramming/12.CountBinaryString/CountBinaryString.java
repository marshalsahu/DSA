import java.util.*;
public class CountBinaryString {
    //count binary string with no consecutive zero
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // int[] dp0 = new int[n+1];
        // int[] dp1 = new int[n+1];
        
        // dp0[1] = 1;
        // dp1[1] = 1;

        // for(int i=2; i<=n; i++){
        //     dp1[i] = dp0[i-1] + dp1[i-1];
        //     dp0[i] = dp1[i-1];
        // }

        // System.out.println(dp1[n]+dp0[n]);

        int oldCountZero = 1;
        int oldCountOne = 1;
        for(int i=2; i<=n; i++){
            int newCountZero = oldCountOne;
            int newCountOne = oldCountOne + oldCountZero;

            oldCountOne = newCountOne;
            oldCountZero = newCountZero;
        }
        System.out.println(oldCountOne+oldCountZero);
    }
}
