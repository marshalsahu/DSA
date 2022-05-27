import java.util.Scanner;

public class PrintStairPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStairPath(n, "");
        sc.close();
    }

    public static void printStairPath(int n, String ans){

        if(n==0){
            System.out.println(ans);
            return;
        }
        if(n < 0){
            return;
        }
        printStairPath(n-1, ans+"1");
        printStairPath(n-2, ans+"2");
        printStairPath(n-3, ans+"3");
    }
}
