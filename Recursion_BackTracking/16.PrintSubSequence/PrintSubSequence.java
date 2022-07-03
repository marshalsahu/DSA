import java.util.Scanner;
//here we use concept of level and options.
 // for abc : step 1. : (ques,ans) => (abc,"") ----> level1
 // level2 : (bc,a) , (bc, "") ---> options(to include or not include a)
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
