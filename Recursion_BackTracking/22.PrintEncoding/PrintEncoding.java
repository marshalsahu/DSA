import java.util.Scanner;

public class PrintEncoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printEncoding(str,"");
        sc.close();
    }

    public static void printEncoding(String ques, String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }else if(ques.length() == 1){
            char ch = ques.charAt(0);
            if(ch == '0'){
                return;
            }else{
                char chEncoded = (char)('A'+ch-'0'-1);
                System.out.println(ans+chEncoded);
                return;
            }
        }else{
            char ch = ques.charAt(0);
            String rem = ques.substring(1);
            if(ch == '0'){
                return;
            }else{
                char chEncoded = (char)('A'+ch-'0'-1);
                printEncoding(rem, ans+chEncoded);
               
            }
            String ch12 = ques.substring(0,2);
            String roq12 = ques.substring(2);
            int chv12 = Integer.parseInt(ch12);
            if (chv12 <= 26){
                char code =  (char)('a'+chv12-1);
                printEncoding(roq12, ans+code);
            }

        }
    }
}
