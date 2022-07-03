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
        //e : getsp(5,0) : all possible path from stair 5 to stair 0.
        //f1 : getsp(n-1,0) => getsp(4,0) : all possible path from stair n-1 to stair 0. 
        //f2 : getsp(n-2,0) => getsp(3,0): all possible path from stair n-2 to stair 0. 
        //f3 : getsp(n-3,0) => getsp(2,0): all possible path from stair n-3 to stair 0. 

        //e-f : 1 * getsp(4,0) + 2 *(3,0) + 3*(2,0) i.e adding 1 to all steps from 4 to 
        //0 plus adding 2 to all steps from 3 to 0 plus adding 3 to all steps from 2 to 0.

        //getsp(0,0) : go from stair 0 to 0, which is possible. we don't need to move. so  there is a path and that path is [""] i.e, empty path.
        //getsp(-1,0) : go from stair -1 to 0, which is not possible. so path is []


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
