import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathWithJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> res = getMazePathWithJump(1,1,n,m);
        System.out.println(res);
        sc.close();
    }

    public static ArrayList<String> getMazePathWithJump(int sr, int sc, int dr, int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> res = new ArrayList<String>();
            res.add("");
            return res;
        }

        ArrayList<String> paths = new ArrayList<String>();
        
        for(int ms=1; ms <= dc-sc; ms++){
            ArrayList<String> hpaths = getMazePathWithJump(sr, sc+ms, dr, dc);
            for(String hpath : hpaths){
                paths.add("h"+ms+hpath);
            }
        }
        for(int ms=1; ms <= dr-sr; ms++){
            ArrayList<String> vpaths = getMazePathWithJump(sr+ms, sc, dr, dc);
            for(String vpath : vpaths){
                paths.add("v"+ms+vpath);
            }
        }
        for(int ms=1; ms <= dr-sr && ms <= dc-sc; ms++){
            ArrayList<String> dpaths = getMazePathWithJump(sr+ms, sc+ms, dr, dc);
            for(String dpath : dpaths){
                paths.add("d"+ms+dpath);
            }
        }
        return paths;

        
    }
}
