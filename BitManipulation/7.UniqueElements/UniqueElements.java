
import java.util.*;


//find element that appers once while all other elements appear twice.
public class UniqueElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i< n ;i++){
            arr[i]= sc.nextInt();
        }

        int unique = 0;
        for(int element : arr){
            unique = unique ^ element;
        }
        System.out.println(unique);
        sc.close();
    }
}
