package MinimumXorPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MininumXorPairs {

    public static void solution(int[] arr){
        Arrays.sort(arr);
        ArrayList<String> res = new ArrayList<>();
        int min = Integer.MIN_VALUE;
        for(int i=0; i< arr.length -1; i++){
            int xor = arr[i] ^ arr[i+1];
            if( min > xor){
                min = xor;
                res = new ArrayList<>();
                res.add(i+","+(i+1));
            }if(min == xor){
                res.add(i+","+(i+1));
            }
        }
        for(String str: res){
            System.out.println(str);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i< n; i++){
            arr[i]= sc.nextInt();
        }
        solution(arr);
        sc.close();
    }   
}
