import java.util.Scanner;

public class DisplayArrayReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i< n ; i++){
            arr[i] = sc.nextInt();
        }

        displayArrayReverse(arr, 0);
        sc.close();
    }

    public static void displayArrayReverse(int[] arr, int n) {

        //expectation = dar(arr,0) = [1,2,3,4,5]
        //faith = dar(arr,1) = [1,2,3,4]
        if(arr.length == n){
            return;
        }

        displayArrayReverse(arr, n+1);
        System.out.println(arr[n]);
    }
}
