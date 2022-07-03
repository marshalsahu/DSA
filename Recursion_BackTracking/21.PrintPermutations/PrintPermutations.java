import java.util.Scanner;

//level and order is used
//level 1 : (abc, "") => question,ans
//level 2 : (bc, "a"),             (ac, "b"),        (ab,"c")  : total options =3 i.e, length of ques
//level 3 : (c,"ab"),(b,"ac"),    (c,"ba"),(a,"bc"),(b,"ca"),(a,"cb") : total options =2
//level 4 : ("","abc"),("","acb"),("","bac"),("","bca"),("","cab"),("","cba") : toatl options= 1

public class PrintPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printPermutations(str, "");
        sc.close();
    }

    public static void printPermutations(String ques, String ans){

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<ques.length(); i++){
            char ch = ques.charAt(i);
            String startPart = ques.substring(0,i);
            String endPart = ques.substring(i+1);
            String rem = startPart+endPart;
            printPermutations(rem, ans+ch);
        }
    }
}
