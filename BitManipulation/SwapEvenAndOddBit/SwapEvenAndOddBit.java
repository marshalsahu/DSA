package SwapEvenAndOddBit;

import java.util.*;
public class SwapEvenAndOddBit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int evenMask = 0xAAAAAAAA;
        int oddMask = 0x55555555;

        int odds = oddMask & n;
        int evens = evenMask & n;

        odds <<= 1;
        evens >>= 1;

        n = odds | evens;
        System.out.println(n);
        sc.close();
    }
    
}
