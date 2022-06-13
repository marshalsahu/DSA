package SameNoOfSetBits;
//find count of same number of set bit as that of N
import java.util.*;

public class SameSetBit {

    public static long ncr(long n, long r){
        if( n < r){
            return 0L;
        }
        long result =1L;

        for(int i=0; i<r; i++){
            result  = result*( n-i);
            result = result / (i+1);
        }
        return result;

    }

    public static long solution(long n, int k, int i){
         if( i==0){
             return 0;
         }
         long mask = 1l << i;

         long res = 0;
         if((n & mask)==0){
             res = solution(n, k, i-1);
         }else{
            long res1 = solution(n, k-1, i-1);
            long res0 = ncr(i,k);
            res = res1 + res0;
         }
         return res;
    }

    public static int csb(long n){
        int count =0;
        while(n > 0){
            long mask = n & -n;
            count++;
            n -= mask;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int k = csb(n);
        long ans= solution(n, k, 63);
        System.out.println(ans);
        sc.close();
    }
}
