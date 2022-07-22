import java.util.*;
public class NQueenProblemSecond {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] chess = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n - 1];
        boolean[] rdiag = new boolean[2*n - 1];
        solution(chess, 0,cols,ndiag,rdiag,"");
        sc.close();
    }
    

    public static void solution(boolean[][] chess, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag, String asf){

        if(row == chess.length){
            System.out.println(asf);
            return;
        }
        for(int col = 0; col < chess[0].length; col++){
            if(cols[col] == false && ndiag[row+col] == false && rdiag[row-col+chess.length-1] == false){
                chess[row][col] = true;
                cols[col] = true;
                ndiag[row+col] = true;
                rdiag[row-col+chess.length-1] = true;
                solution(chess,row+1, cols, ndiag, rdiag, asf+"("+row+"->"+col+")");
                chess[row][col] = false;
                cols[col] = false;
                ndiag[row+col] = false;
                rdiag[row-col+chess.length-1] = false;
            }
        }
    }
    

}
