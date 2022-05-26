package RightMostSetBitMask;
// Right Most Set Bit Mask.

import java.util.*;
import java.io.*;

public class RSBM{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int rsbm = n & (-n); //-n = 2's complement of n. 
        // System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(rsbm));

    }
}