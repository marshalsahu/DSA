import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> res = getMazePath(1,1,n,m);
        System.out.println(res);
    }

    public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc){

        if(sr == dr && sc == dc){
            ArrayList<String> str = new ArrayList<>();
            str.add("");
            return str;
        }
        ArrayList<String> movehm1 = new ArrayList<>();
        ArrayList<String> movevm1 = new ArrayList<>();
        if(sc < dc){
            movehm1= getMazePath(sr, sc+1, dr, dc);
        }
        if(sr < dr ){
           movevm1= getMazePath(sr+1, sc, dr, dc);
        }
        ArrayList<String> totalMove = new ArrayList<String>();
        for(String res : movehm1){
            totalMove.add("h"+res);
        }
        for(String res : movevm1){
            totalMove.add("v"+res);
        }

        return totalMove;
    }
}
