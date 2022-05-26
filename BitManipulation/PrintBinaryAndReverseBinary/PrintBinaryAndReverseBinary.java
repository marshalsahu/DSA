package PrintBinaryAndReverseBinary;

import java.util.Scanner;

public class PrintBinaryAndReverseBinary {

    public static void solution(int n){
        boolean flag = false;
        int rev = 0;
        int j = 0;
        for(int i=31; i >= 0 ; i--){
            int mask = (1 << i);

            if(flag){
                if((mask & n) != 0){
                    System.out.print(1);
                    int mask2 = (1 << j);
                    rev |= mask2;
                }else{
                    System.out.print(0);
                }
                j++;

            }else{
                if((mask & n) != 0){
                    System.out.print(1);
                    flag = true;
                    int mask2 = (1 << j);
                    rev |= mask2;
                    j++;
                }
            }
        }
        System.out.println();
        System.out.println(rev);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        solution(n);
        sc.close();
    }
}
