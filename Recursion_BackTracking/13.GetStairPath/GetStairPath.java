import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> paths = getStairPath(n);
        System.out.println(paths);
        sc.close();
    }

    public static ArrayList<String> getStairPath(int n){

        if(n==0){
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        if(n < 0){
            ArrayList<String> res = new ArrayList<>();
            return res;
        }

        ArrayList<String> pathNm1 = getStairPath(n-1);
        ArrayList<String> pathNm2 = getStairPath(n-2);
        ArrayList<String> pathNm3 = getStairPath(n-3);
        ArrayList<String> pathN = new ArrayList<>();
        for(String str: pathNm1){
            pathN.add("1"+str);
        }
        for(String str: pathNm2){
            pathN.add("2"+str);
        }
        for(String str: pathNm3){
            pathN.add("3"+str);
        }
        return pathN;
    }
}
