package SumBitDiffAmongAllPair;
//sum of bit diff among all pairs. [a,b,c,d] = [ab, ac, ad, ba, bc,bd, ca,cb,cd, da,db,dc], we nedd to find the sum of bit diff among these pair.
import java.util.*;

public class SumBitDiffAmongAllPair {

    public static void solution(int[] arr){
        int totalSum = 0;
        for(int i=0 ; i < 32 ; i++){
            int mask = 1 << i;
            int count0 = 0;
            int count1 = 0;
            for(int j=0; j < arr.length; j++){
                
                if( (arr[j] & mask)==0){
                    count0 += 1;
                }else{
                    count1 += 1;
                }
            }
            totalSum += count0 * count1 * 2;
        }
        System.out.println(totalSum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i< n;i++){
            arr[i] = sc.nextInt();
        }
        solution(arr);
        sc.close();
    }
}
