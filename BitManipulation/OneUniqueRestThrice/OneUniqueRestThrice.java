package OneUniqueRestThrice;

import java.util.*;
import java.io.*;

//find element that appears once where rest all appear thrice.

public class OneUniqueRestThrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i< n ;i++){
            arr[i]= sc.nextInt();
        }

        int tn = Integer.MAX_VALUE, tnp1 = 0, tnp2 = 0;
        for(int i=0; i<n; i++){
            int cwtn = tn & arr[i];
            int cwtnp1 = tnp1 & arr[i];
            int cwtnp2 = tnp2 & arr[i];

            tn = tn & (~cwtn);
            tnp1 = tnp1 | cwtn ;
            tnp1 = tnp1 & (~cwtnp1);
            tnp2 = tnp2 | cwtnp1;
            tnp2 = tnp2 & (~cwtnp2);
            tn = tn | cwtnp2;
        }
        System.out.println(tnp1);
    }
}
