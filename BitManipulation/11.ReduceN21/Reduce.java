
import java.util.*;

//reduce a number to 1 in minimum steps. print steps.
public class Reduce {

    public static void solution(int n){
        int steps = 0;

        while(n != 1){
            if( n % 2 == 0){
                n = n/2;
            }else if( n == 3){
                n = n-1;
            }else if( (n & 3) == 1) {   // checking if n is of type 4n+1, we can use n%4 here instead of n&3
                n = n-1;
            }else if ((n & 3) == 3){
                n = n+1;
            }
            steps += 1;
        }
        System.out.println(steps);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        solution(n);
        sc.close();
    }
}
