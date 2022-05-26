import java.util.Scanner;

public class LastIndexOccurence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
    
        for(int i=0; i< n ; i++){
            arr[i] = sc.nextInt();
        }
        int data = sc.nextInt();
        int index = lastIndexOccurence(arr,0,data);
        System.out.println(index);
        sc.close();
    }

    public static int lastIndexOccurence(int[] arr, int n ,int data) {
        if(arr.length == n){
            return -1;
        }

        int lstElementIdx = lastIndexOccurence(arr, n+1, data);
        if(lstElementIdx == -1){
            if(arr[n]== data){
                lstElementIdx = n;
            }
        }
        return lstElementIdx;
        
    }
   
}
