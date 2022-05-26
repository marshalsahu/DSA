import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        int res = powerLinear(x,n);
        System.out.println(res);
        sc.close();
    }

    private static int powerLinear(int x, int n){

        if(n==0){
            return 1;
        }

        int pxnd2 = powerLinear(x, n/2);
        int result = pxnd2 * pxnd2;

        if( n%2 == 1){
            result = x * pxnm1;
        }
        return result;
    }
}
