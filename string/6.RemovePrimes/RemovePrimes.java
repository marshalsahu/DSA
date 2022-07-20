import java.lang.*;
import java.io.*;
import java.util.*;

public class RemovePrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0; i<n; i++){
            arrayList.add(sc.nextInt());
        }

        //removeprime

        for(int i=arrayList.size()-1; i>=0; i--){
            if(isPrime(arrayList.get(i))){
                arrayList.remove(i);
            }
        }

        for(int i=0; i<arrayList.size(); i++){
            System.out.print(arrayList.get(i)+" ->");
        }

    }

    public static boolean isPrime(int n){
        for(int i=2 ; i*i<=n ; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
