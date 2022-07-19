import java.util.*;
public class MaximumSumNonadjacent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int include = arr[0];
        int exclude = 0;

        for(int i=1; i<arr.length; i++){
            int newInclude = exclude + arr[i];
            int newExclude = Math.max(include, exclude);

            include = newInclude;
            exclude = newExclude;
        }
        
        System.out.println(Math.max(include, exclude));
    }
}
