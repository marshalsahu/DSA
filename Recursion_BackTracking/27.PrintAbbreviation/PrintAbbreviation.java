import java.util.Scanner;
// for ex pep : {pep, pe1, p1p,p2,1ep,1e1,2p,3}
public class PrintAbbreviation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solution(str, "", 0, 0);
    }

    public static void solution(String s, String asf, int count, int pos){

        if(s.length() == pos){
            if(count> 0){
                System.out.println(asf+count);
            }else{
                System.out.println(asf);
            }
            return;
        }

         if(count > 0){
            solution(s, asf+count+s.charAt(pos), 0, pos+1);
         }else{
            solution(s, asf+s.charAt(pos), 0, pos+1);
         }

         solution(s, asf, count+1, pos+1);
    }
}
