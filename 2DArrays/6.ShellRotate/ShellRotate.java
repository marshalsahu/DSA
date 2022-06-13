import java.util.Scanner;

// from 2D array, you are given a shell number (s), you are given a number (r) representing num of anticlock rotations (for +ve number) of shell s.
//you are required to rotate the Sth shell of matrix by r rotations.
public class ShellRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];

        for(int i=0; i< row; i++){
            for(int j=0; j< col; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int s = sc.nextInt();
        int r = sc.nextInt();

        //display of matrix
        System.out.println("Given Matrix is");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


        shellRotate(arr, s, r);

         //display of matrix
         System.out.println("Result is ");
         for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


        sc.close();
    }

    public static void shellRotate(int[][] arr, int shell, int rotate){
        int[] oned = getOneDArrayFromShell(arr,shell);
        rotateOneDArray(oned, rotate);
        fillOneDArraytoShell(arr, shell, oned);
    }
    public static int[] getOneDArrayFromShell(int[][] arr, int shell){
        int minr = shell-1;
        int minc = shell-1;
        int maxr = arr.length - shell;
        int maxc = arr[0].length - shell;

        //totalelements = leftwall + bottomwall + rightwall + topwall - 4(to exclude corners which exists twice)
        // totalElements = 2 * (maxr - minr + 1) + 2*(maxc - minc + 1) - 4;
        int totalElements = 2 * ( maxr-minr + maxc-minc);
        int[] oned = new int[totalElements];
        int idx = 0;

        //leftwall
        for(int i=minr,j=minc; i <= maxr ; i++){
            oned[idx] = arr[i][j];
            idx++;
        }

        //bottomwall
        for(int i=maxr,j=minc+1; j <= maxc ; j++){
            oned[idx] = arr[i][j];
            idx++;
        }

        //rightwall
        for(int i=maxr-1,j=maxc; i >= minr ; i--){
            oned[idx] = arr[i][j];
            idx++;
        }

        //topwall
        for(int i=minr,j=maxc-1; j >= minc+1 ; j--){
            oned[idx] = arr[i][j];
            idx++;
        }
        return oned;
    }

    public static void fillOneDArraytoShell(int[][] arr, int shell, int[] oned){
        int minr = shell-1;
        int minc = shell-1;
        int maxr = arr.length - shell;
        int maxc = arr[0].length - shell;

        //totalelements = leftwall + bottomwall + rightwall + topwall - 4(to exclude corners which exists twice)
        // totalElements = 2 * (maxr - minr + 1) + 2*(maxc - minc + 1) - 4;
        
        int idx = 0;

        //leftwall
        for(int i=minr,j=minc; i <= maxr ; i++){
            arr[i][j] = oned[idx];
            idx++;
        }

        //bottomwall
        for(int i=maxr,j=minc+1; j <= maxc ; j++){
            arr[i][j] = oned[idx];
            idx++;
        }

        //rightwall
        for(int i=maxr-1,j=maxc; i >= minr ; i--){
            arr[i][j] = oned[idx];
            idx++;
        }

        //topwall
        for(int i=minr,j=maxc-1; j >= minc+1 ; j--){
            arr[i][j] = oned[idx];
            idx++;
        }
    }

    //Rotation of 1D array.
    public static void rotateOneDArray(int[] oned, int rotate){
        rotate = rotate % oned.length;
        if( rotate < 0){
            rotate += oned.length;
        }
        reverse(oned, 0, oned.length-rotate-1);
        reverse(oned, oned.length-rotate, oned.length-1);
        reverse(oned,0,oned.length-1);
    }

    //Reverse of 1D array.
    public static void reverse(int[] oned, int start, int end){
        while(start < end){
            int temp = oned[start];
            oned[start] = oned[end];
            oned[end] = temp;
            start++;
            end--;
        }
    }
}
