package DuplicateAndMissing;

//find duplicate and missig number from 1 to N
import java.util.*;
import java.io.*
;
public class DuplicateAndMissing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i< n ;i++){
            arr[i]= sc.nextInt();
        }

        int xor = 0;
        for(int x : arr){
            xor ^= x;
        }
        for(int i=1 ; i<=n ;i++){
            xor ^= i;
        }

        int rmsb = xor & -xor;
        int x=0;
        int y=0;
        for(int elem : arr){
            if( (rmsb & elem) == 0){
                x ^= elem;
            }else{
                y ^= elem;
            }
        }
        for(int i=1 ; i<=n ;i++){
            if( (rmsb & i) == 0){
                x ^= i;
            }else{
                y ^= i;
            }
        }

        for(int elem : arr){
            if( elem == x){
                System.out.println("Missing Number -> "+ y);
                System.out.println("Repeating Number -> "+x);
                break;
            }else{
                System.out.println("Missing Number -> "+ x);
                System.out.println("Repeating Number -> "+y);
                break;
            }
        }

    }
    
}
