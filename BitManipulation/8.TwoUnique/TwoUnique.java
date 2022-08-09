//all repeating except two.. [12, 24, 25, 45, 24, 45] = 12, 25
import java.util.*;

public class TwoUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i< n ;i++){
            arr[i]= sc.nextInt();
        }

        int xor = 0;
        for(int elem : arr){
            xor = xor ^ elem;
        }
        int rmsb = xor & -xor;
        int x = 0;
        int y = 0;
        for(int elem : arr){
            if( (elem & rmsb) ==0 ){
                x = x^elem;
            }else{
                y = y ^ elem;
            }
        }
        if( x  > y){
            System.out.println(y);
            System.out.println(x);
        }else{
            System.out.println(x);
            System.out.println(y);
        }
        sc.close();
    }
}
