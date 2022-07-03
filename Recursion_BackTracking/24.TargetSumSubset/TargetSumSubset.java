import java.util.ArrayList;
import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] arr = new int[num];

        for(int i=0; i < num; i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
    
        solution(arr,0,"",0,tar);
    }

    public static void solution(int[] arr, int idx, String set, int sos, int target){

        if (arr.length == idx){
            if(sos == target){
                System.out.println(set);
                return;
            }
            return;
        }

        solution(arr, idx+1, set, sos, target);
        solution(arr, idx+1,set+arr[idx]+",", sos+arr[idx], target);

    }
}
