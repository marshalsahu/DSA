import java.util.Scanner;
//print the instruction to move the disks form tower1 to tower 2 using tower 3. following rules below:
//1.move 1 disk at a time
//2.never place a smaller disk under a larger disk
//3.you can only move a disk at the top
public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //no of disks
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int t3 = sc.nextInt();

        toh(n,t1,t2,t3);
        sc.close();

        
    }

    public static void toh(int n, int t1,int t2, int t3){
        if(n==0){
            return;
        }
        toh(n-1,t1,t3,t2); //will print instructions to move n-1 disks from t1 -> t3 using t2.
        System.out.println(n+"["+t1+"->"+t3+"]");
        toh(n-1,t3,t2,t1);
    }
}
