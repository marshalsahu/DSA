import java.util.Scanner;
//for [a,b,c,d] = sum of all pair => [(a,a), (a,b), (a,c), (a,d)]
                                   //[(b,a), (b,b), (b,c), (b,d)]
                                   //[(c,a), (c,b), (c,c), (c,d)]
                                   //[(d,a), (d,b), (d,c), (d,d)]
                                   // all pair will cancel out except [ (a,a), (b,b), (c,c), (d,d)]
public class XorOfSumOfAllPair {

    public static int solution(int[] arr){
        int xor = 0;
        for(int val : arr){
            xor  = xor ^ (2 * val);
        }
        return xor;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }
}
