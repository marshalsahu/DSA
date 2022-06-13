import java.util.Scanner;

class MatrixMul{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input for 1st matrix
        int m1r = sc.nextInt();
        int m1c = sc.nextInt();

        int[][] m1 = new int[m1r][m1c];

        for(int i=0; i< m1r; i++){
            for(int j=0; j< m1c; j++){
                m1[i][j] = sc.nextInt();
            }
        }

        //input for 2nd matrix
        int m2r = sc.nextInt();
        int m2c = sc.nextInt();

        int[][] m2 = new int[m2r][m2c];

        for(int i=0; i<m2r; i++){
            for(int j=0; j<m2c; j++){
                m2[i][j] = sc.nextInt();
            }
        }

        //[1,2]  [3,2]  [5, 10]
        //[2,1]  [1,4]  [7, 8]

        //matrix multiplication code
        int[][] res = new int[m1r][m2c];
        if(m1c == m2r){

            for(int i=0; i< m1r; i++){ //i=0
                for(int j=0; j<m2c ; j++){// j=1
                    for(int k=0; k<m2r ; k++){ //k = 0,1
                      res[i][j] += m1[i][k] * m2[k][j];   
                    }
                    
                }
            }


        }else{
            System.out.println("Matrix Mul not possible");
        }

        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}