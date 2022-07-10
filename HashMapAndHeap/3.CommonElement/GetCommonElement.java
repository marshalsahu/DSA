import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElement {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int[] arr1 = new int[a1];

        for(int i=0; i<a1 ; i++){
            arr1[i] = sc.nextInt();
        }
        int a2 = sc.nextInt();
        int[] arr2 = new int[a2];

        for(int i=0; i<a2 ; i++){
            arr2[i] = sc.nextInt();
        }

        for(int ele : arr1){
            if(hm.containsKey(ele)){
                int val = hm.get(ele);
                hm.put(ele, val+1);
            }else{
                hm.put(ele, 1);
            }
        }
        
        for(int val : arr2){
            if(hm.containsKey(val)){
                System.out.println(val);
                hm.remove(val);
            }
        }
    }
}
