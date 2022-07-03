import java.util.Scanner;

//level and options : consider input 578
//level1 : ("578","")
//level2 : ("78", "m"),("78","n"),("78","o")
//level3 : ("8", "mt"),("8", "mu"),("8","nt"),("8","nu"),("8","ot"),("78","ou")
//level4 : ("", "mtv"),("", "mtw"),("", "mtx"),("", "muv"),("", "muw"),("", "mux"),("","ntv"),("","ntw"),("","ntx"),("","nuv"),("","nuw"),("","nux"),("", "otv"),("", "otw"),("", "otx"),("", "ouv"),("", "ouw"),("", "oux")
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
