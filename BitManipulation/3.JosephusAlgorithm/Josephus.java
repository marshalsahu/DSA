import java.util.*;

//Josephus algo gives us the number which is left if we start to remove alternate numbers starting from 1 to n in a circular fashion.
public class Josephus {

    public static int powerof2(int n){
        int x = 1;
      
        while(x*2 <= n){
       
            x=x*2;
        }
        return x;

    }
    public static int solution(int n){
        int hp2 = powerof2(n);
        int l = n-hp2;
        return 2*l+1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = solution(n);

        System.out.println(ans);

        sc.close();
    }
}
