package KernighansAlgorithm;
import java.util.*;
import java.io.*;

// to count set bits in an integer. -> findrightmost1 and subtract it from n
public class Kernighan {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int counter = 0;
        // int temp = n; 
        while(n > 0){
            int rmsb = n & (-n);
            counter+= 1;
            n -= rmsb;
        }
        // System.out.println(Integer.toBinaryString(temp));
        System.out.println(counter);
    }
}
