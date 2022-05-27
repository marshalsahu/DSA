import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> result = getSubsequence(str);
        System.out.println("ans is ");
        for(String s : result){
            System.out.println(s);
        }
        sc.close();
    }

    public static ArrayList<String> getSubsequence(String s){

        if(s.length() == 0){
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        char ch = s.charAt(0);
        String ros = s.substring(1);
        ArrayList<String> res = getSubsequence(ros);
        ArrayList<String> resNew = new ArrayList<>();
        for(String str : res){
            resNew.add("_"+str);
        }
        for(String str : res){
            resNew.add(ch+str);
        }
        return resNew;
    }
}
