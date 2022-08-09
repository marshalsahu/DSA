public class NQueenBranchAndBound {

    public static void solution(int[][] chess, int row, int[] chessColumn, int[] chessNDiag, int[] chessRDiag){
        if(row == chess.length){
            display(chess);
            return;
        }
        
        for(int j = 0; j < chess.length; j++){
            if( chess[row][j] == 0 && chessColumn[j]==0 &&
                    chessNDiag[row+j] == 0 && chessRDiag[row-j+chess.length-1]==0){
                        chess[row][j] = 1;
                        chessColumn[j] = 1;
                        chessNDiag[row+j] = 1;
                        chessRDiag[row-j+chess.length-1] = 1;
                        solution(chess,row+1,chessColumn,chessNDiag,chessRDiag);
                        chessColumn[j] = 0;
                        chessNDiag[row+j] = 0;
                        chessRDiag[row-j+chess.length-1] = 0;
                        chess[row][j] = 0;
                    }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] chess = new int[n][n];
        int[] chessColumn = new int[n];
        int[] chessNDiag = new int[2*n -1];
        int[] chessRDiag = new int[2*n -1];
        display(chess);
        solution(chess,0,chessColumn,chessNDiag, chessRDiag);
        display(chess);
    }

    public static void display(int[][] chess){
        System.out.println("Printing chess configuration");
        for(int i=0; i < chess.length; i++){
            for(int j=0; j < chess.length; j++){
                System.out.print(chess[i][j] +"\t");
            }
            System.out.println();
        }
    }
}
