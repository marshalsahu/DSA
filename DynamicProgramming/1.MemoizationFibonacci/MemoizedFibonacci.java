import java.util.Scanner;

public class MemoizedFibonacci{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int fib = fib(n, new int[n+1]);
        System.out.println(fib);
        sc.close();

    }

    public static int fib(int n){
        if( n == 0 || n == 1){
            return n;
        }
        int fibnm1 = fib(n-1);
        int fibnm2 = fib(n-2);
        return fibnm1 + fibnm2;
    }


    public static int memoizedFib(int n, int[] arr){
        if(n == 0 || n == 1){
            return n;
        }

        if( arr[n] != 0){
            return arr[n];
        }

        int fibnm1 = memoizedFib(n-1, arr);
        int fibnm2 = memoizedFib(n-2, arr);
        int fib = fibnm1 + fibnm2;
        arr[n] = fib;
        return arr[n];
    }
}