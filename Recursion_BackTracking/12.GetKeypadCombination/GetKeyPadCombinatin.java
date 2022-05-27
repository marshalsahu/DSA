import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetKeyPadCombinatin {


    static String codes[] ={".;","abc", " def","ghi","jkl","mno", "pqrs","tu","vwx","yz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        
        ArrayList<String> result = getKpc(n);
        System.out.println("result is "+result.size());
        for(String s: result){
            System.out.println(s);
        }
        sc.close();

    }

    public static ArrayList<String> getKpc(String s){
        if(s.length() == 0){
            ArrayList<String> newRes = new ArrayList<String>();
            newRes.add("");
            return newRes;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);
        String sch = codes[ch-'0'];
        ArrayList<String> res = getKpc(ros);
        ArrayList<String> newRes = new ArrayList<String>();
        for(String str : res){
            for(char tch : sch.toCharArray()){
                newRes.add(tch+str);
            }
        }
        return newRes;
    }

    
}
