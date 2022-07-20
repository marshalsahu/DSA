import java.lang.*;
import java.io.*;
import java.util.*;

public class PermutationString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        permutation(str);
    }

    public static void permutation(String str){
        int n = str.length();
        int totalPermutations = totalPermutation(n);

        for(int i=0; i<totalPermutations; i++){
            int temp = i;
            StringBuilder sb = new StringBuilder(str);
            for(int div=n; div>=1; div--){
                
                int q = temp/div;
                int rem = temp%div;
                System.out.print(sb.charAt(rem));
                sb.deleteCharAt(rem);
                temp = q;
            }

            System.out.println();
        }
    }

    public static int totalPermutation(int n){
        int result = 1;

        for(int i=2; i<=n; i++){
            result *= i;
        }
        return result;
    }
}
