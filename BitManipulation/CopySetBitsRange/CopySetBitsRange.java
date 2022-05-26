package CopySetBitsRange;

import java.util.Scanner;

//copy set bits from a to b in a given range.
public class CopySetBitsRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int range1 = sc.nextInt();
        int range2 = sc.nextInt();

        int mask1 = 1 << (range2-range1+1);
        mask1 -= 1;
        mask1 = mask1 << range1-1;

        int mask2 = mask1 & a;
        b = mask2 | b;
        
        sc.close();
    }
}
