package PrintAbbreviation;

import java.util.*;
//print abbreviation i.e, "pep" = > ["pep", "pe1", 'p1p', 'p2', '1ep', '1e1','2p','3']
public class PrintAbbreviation {

    public static void solve(String str){

        for(int i = 0 ; i < ( 1 << str.length()); i++){
            StringBuilder sb = new StringBuilder();
            int count =0;
            for(int j=0; j < str.length(); j++){
                char ch = str.charAt(j);
                int bitMask = 1 << str.length()-1-j;
                if( (i & bitMask)==0){
                    if(count==0){
                        sb.append(ch);
                    }else{
                        sb.append(count);
                        sb.append(ch);
                        count = 0;
                    }
                }else{
                    count += 1;
                }
            }
            if(count != 0){
                sb.append(count);
            }
            System.out.print(sb + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        solve(str);
    }
}
