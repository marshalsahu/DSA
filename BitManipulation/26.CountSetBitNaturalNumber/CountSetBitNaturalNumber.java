package CountSetBitNaturalNumber;

import java.util.Scanner;

public class CountSetBitNaturalNumber {
    //f(n) = 2^(x-1)  * ( x + n - 2^x + 1) + f(n-2^x)
    public static int solution(int n) {
        if( n == 0){
            return 0;
        }

        int htillN = highestPower2tillN(n);
        int csbtillhp2 = htillN * (1 << (htillN-1));
        int cmsb1safterhp2 = n - (1 << htillN) + 1;
        int left = n - (1 << htillN);
        int total = csbtillhp2 + cmsb1safterhp2 + solution(left);
        
        return total;
    }

    public static int highestPower2tillN(int x){
        int power=0;
        while( (1 << power) <= x){
            power++;
        }
        return power-1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = solution(n);
        System.out.println(result);
        sc.close();
    }
}
