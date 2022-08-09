import java.util.*;

public class EqualSumSubsetPartition {

    public static void solution(int[] arr, int vidx, int n, int k, int[] subsetsum, ArrayList<ArrayList<Integer>> ans, int sssf){

        if(vidx == n){
            if(sssf == k){
                boolean flag = true;
                for(int i = 0; i < subsetsum.length - 1; i++){
                    if(subsetsum[i] != subsetsum[i+1]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for( ArrayList<Integer> partition : ans){
                        System.out.print(partition+" ");
                    }
                    System.out.println();
                }
            }
            return;
        }
        
        for(int i = 0; i < ans.size(); i++){
            if(ans.get(i).size() > 0){
                ans.get(i).add(arr[vidx]);
                subsetsum[i] += arr[vidx];
                solution(arr, vidx+1, n, k, subsetsum, ans, sssf);
                subsetsum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size() -1);
            }else{
                ans.get(i).add(arr[vidx]);
                subsetsum[i] += arr[vidx];
                solution(arr, vidx+1, n, k, subsetsum, ans, sssf+1);
                subsetsum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
                break;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int k = sc.nextInt();

        if( k == 1){
            System.out.print("[");
            for(int i = 0; i < n; i++){
                System.out.print(arr[i]+",");
            }
            System.out.print("]");
            return;
        }

        if( n < k || sum % k != 0){
            System.out.println("-1");
            return;
        }

        int[] subsetSum = new int[k];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(k);
        for(int i = 0; i < k; i++){
            ans.add(new ArrayList<>());
        }

        solution(arr,0,n,k,subsetSum, ans, 0);
    }
}
