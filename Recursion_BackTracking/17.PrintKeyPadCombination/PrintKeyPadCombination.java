import java.util.Scanner;

public class PrintKeyPadCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printKPC(str, "");
        sc.close();
    }
    static String codes[] ={".;","abc", " def","ghi","jkl","mno", "pqrs","tu","vwx","yz"};

    public static void printKPC(String ques, String ans){

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String code = codes[ch-'0'];
        String roq = ques.substring(1);
        for(char c : code.toCharArray()){
            printKPC(roq, ans+c);
        }
    }
}
