import java.util.ArrayList;
import java.util.Scanner;
//subsequence of string abc is ['', 'a', 'b','c','ab','ac','bc','abc'] : i.e, every character has possiblity whether it can be included or not
//for n length , total subsequence will be 2^n

//substring is different from subsequence as substring of abc will be ['a', 'ab', 'abc', 'b', 'bc', 'c'], total substring is (n*(n+1))/2
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
        //f : getss(abc) = ["","c","b","bc","a","ac","ab","abc"]
        //e : getss(bc) = ["", "c","b","bc"]
        //e-f : *["", "c","b","bc"] + a*["", "c","b","bc"] //every character has possibility whether it can be included in the result or not
        //2^0 = 1 its identity.
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
