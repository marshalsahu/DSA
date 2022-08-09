import java.util.Scanner;

public class GameOfExecution {

    public static int solution(int n, int k){
        if(n == 1){
            return 0;
        }
        int x = solution(n-1, k);
        int y = (x + k) % n;
        return y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n,k));
    }
}
