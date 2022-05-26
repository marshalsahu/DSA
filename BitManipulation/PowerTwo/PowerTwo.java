package PowerTwo;
import java.util.*;
public class PowerTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = a-1;
        if ( ( a & b) == 0){
            System.out.println("power of 2");
        }else{
            System.out.println("not power of 2");
        }
        sc.close();
    }
}
