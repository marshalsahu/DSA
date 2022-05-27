import java.util.Scanner;

public class PrintMazeWithJumps {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        printMazeWithJumps(1,1,n,m,"");
        sc.close();
    }

    public static void printMazeWithJumps(int sr, int sc, int dr, int dc, String ans){

        if(sr == dr && sc == dc){
            System.out.println(ans);
            return;
        }

        for(int ms=1; ms <= dc-sc; ms++){
            printMazeWithJumps(sr, sc+ms, dr, dc, ans+"h"+ms);
        }
        for(int ms=1; ms <= dr-sr; ms++){
            printMazeWithJumps(sr+ms, sc, dr, dc, ans+"v"+ms);
        }
        for(int ms=1; ms <= dc-sc && ms<=dr-sr; ms++){
            printMazeWithJumps(sr+ms, sc+ms, dr, dc, ans+"d"+ms);
        }
    }
}
