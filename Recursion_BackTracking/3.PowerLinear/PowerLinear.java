import java.util.Scanner;

//to print x raised to power n;
public class PowerLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int res = powerLinear(x,n);
        System.out.println(res);
        sc.close();
    }

    public static int powerLinear(int x, int n){

        if(n==0){
            return 1;
        }

        int pxnm1 = powerLinear(x, n-1);
        int res = x * pxnm1;
        return res;
        
    }
}
