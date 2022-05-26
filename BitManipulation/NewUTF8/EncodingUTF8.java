package NewUTF8;

import java.util.*;

public class EncodingUTF8 {

    public static boolean solve(int[] arr){
        int rbytes = 0;
        for(int elem : arr){
            if (rbytes == 0){
                if( (elem >> 7)== 0b0) {
                    rbytes = 0;
                }else if ( (elem >> 5) == 0b110){
                    rbytes = 1;
                }else if ( (elem >> 4) == 0b1110){
                    rbytes = 2;
                }else if( (elem >> 3) == 0b11110){
                    rbytes = 3;
                }
            }else{
                if( (elem) >> 6 == 0b10){
                    rbytes--;
                }else{
                    return false;
                }
            }
        }

        if(rbytes > 0){
            return false;
        }

        return true;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i< n ;i++){
            arr[i]= sc.nextInt();
        }

        boolean result = solve(arr);
    }
}
