import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = factorial(n);
        System.out.println(res);
        sc.close();
    }

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        int fnm1 = factorial(n-1);
        int fact = n* fnm1;
        return fact;
    }
}
