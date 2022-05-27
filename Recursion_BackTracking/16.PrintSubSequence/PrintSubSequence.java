import java.util.Scanner;

public class PrintSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        printSubSequence(str, "");
        sc.close();
    }

    public static void printSubSequence(String str, String ans) {
        if( str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        printSubSequence(roq, ans+"");
        printSubSequence(roq, ans+ch);
    }
}
