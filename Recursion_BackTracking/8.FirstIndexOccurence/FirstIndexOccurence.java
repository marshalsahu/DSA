import java.util.Scanner;

public class FirstIndexOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i< n ; i++){
            arr[i] = sc.nextInt();
        }
        int data = sc.nextInt();

        firstIndexOccurence(arr,0,data);
        sc.close();
    }

    public static void firstIndexOccurence(int[] arr, int n,int data){
        if(n == arr.length){
            System.out.println("no index");
            return;
        }

        if(arr[n]==data){
            System.out.println("first index is "+ (n));
            return;
        }
        firstIndexOccurence(arr, n+1, data);

    }
}
