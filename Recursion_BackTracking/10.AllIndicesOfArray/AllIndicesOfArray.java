import java.util.Scanner;

public class AllIndicesOfArray {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[] = new int[n];
    
        for(int i=0; i< n ; i++){
            arr[i] = sc.nextInt();
        }
        int data = sc.nextInt();
        int result[] = allIndicesofArray(arr,data, 0,0);
        System.out.println(result);
        System.out.println("ans is");
        for(int i=0; i< result.length ; i++){
            System.out.println(result[i]);
        }
        sc.close();
    }
    //1st way
    public static int[] allIndicesofArray(int[] arr, int data, int idx, int fsf){
        if(idx == arr.length){
            int[] res = new int[fsf];
            return res;
        }

        if(arr[idx] == data){
            fsf+=1;
        }
        int[] res = allIndicesofArray(arr, data, idx+1, fsf);
        if(arr[idx] == data){
            res[fsf-1]= idx;
        }
      
        return res;
        
    }

    //2nd way
    public static int[] resultIndices(int[] arr, int data, int idx, int fsf){

        if(idx == arr.length){
            int[] iarr = new int[fsf];
            return iarr;
        }

        if(arr[idx] == data){
            int[] iarr = resultIndices(arr, data, idx+1, fsf+1);
            iarr[fsf] = idx;
            return iarr;
        }else{
            int[] iarr = resultIndices(arr, data, idx+1, fsf);
            return iarr;
        }
    }
}
