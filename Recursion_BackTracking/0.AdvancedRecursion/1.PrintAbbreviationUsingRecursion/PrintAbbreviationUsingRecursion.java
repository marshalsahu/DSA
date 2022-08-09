import java.util.Scanner;

public class PrintAbbreviationUsingRecursion{

    public static void solution(String s, String asf, int count, int pos){

        if( pos == s.length()){
            if(count == 0){
                System.out.println(asf);
            }else{
                System.out.println(asf+count);
            }
            return;
        }

        if( count > 0)
            solution(s, asf+count+s.charAt(pos), 0, pos+1);
        else
            solution(s, asf+s.charAt(pos), 0, pos+1);

        solution(s, asf, count+1, pos+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        solution(s,"",0,0);

    }
}