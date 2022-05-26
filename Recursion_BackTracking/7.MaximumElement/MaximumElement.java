import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i< n ; i++){
            arr[i] = sc.nextInt();
        }

        int max = findMaximum(arr, 0);
        System.out.println(max);
        sc.close();
    }

    public static int findMaximum(int[] arr, int n) {
        //e: findmax(arr,0) = max 
        //f : findmax(arr,4) = max2
        // if(max2 < arr[n])
        if(n == arr.length-1){
            return arr[n];
        }
        int maxTillNow = findMaximum(arr, n+1);
        if(maxTillNow < arr[n]){
            maxTillNow = arr[n];
        }
        return maxTillNow;
        
    }
}
