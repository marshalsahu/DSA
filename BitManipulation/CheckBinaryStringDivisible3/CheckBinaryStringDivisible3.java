package CheckBinaryStringDivisible3;
//check if binary string is divisible by 3.
import java.util.*;
public class CheckBinaryStringDivisible3 {
    public static void solution(String str){
        int evensum =0;
        int oddsum = 0;
        for(int i=0 ; i < str.length(); i++){
            int bit = str.charAt(i) -'0';
            if( i%2 == 0){
                evensum += bit;
            }else{
                oddsum +=bit;
            }
        }
        int diff = Math.abs(oddsum-evensum);
        if(diff % 3 == 0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        solution(input);
        sc.close();
    }
}
