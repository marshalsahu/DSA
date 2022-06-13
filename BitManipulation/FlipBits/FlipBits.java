package FlipBits;

import java.util.Scanner;
//calculate count of bits to convert A to B
public class FlipBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = a ^ b;
        int count =0;
        while( c > 0){
            int temp = c & -c;
            count += 1;
            c -= temp;
        }
        System.out.println(count);
        sc.close();
    }
}
