import java.util.Scanner;

public class PrintLexicographical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=9; i++){
            solution(n, i);
        }

    }

    public static void solution(int n, int asf){
        if( asf > n){
            return;
        }
       
        System.out.println(asf);
        for(int i=0; i<=9; i++){
            solution(n, asf*10+i);
        }

    }
}
