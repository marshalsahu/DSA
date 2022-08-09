import java.util.Scanner;

public class DivideTwoIntegers {

    //calculate 7n/8 => (8n- n)/8 => ((n << 3) -n ) >> 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int val = ((n << 3) - n) >> 3;
        System.out.println(val);

    }
}
