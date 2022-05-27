import java.util.Scanner;

public class PrintMazePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        printMazePath(1,1,n,m,"");
        sc.close();
    }

    public static void printMazePath(int sr,int sc, int dr, int dc, String ans ){

        if(sr == dr && sc == dc){
            System.out.println(ans);
            return;
        }
        if(sc < dc){
            printMazePath(sr, sc+1, dr, dc, ans+"h");
        }
        if(sr < dr){
            printMazePath(sr+1, sc, dr, dc, ans+"v");
        }
    }
}
