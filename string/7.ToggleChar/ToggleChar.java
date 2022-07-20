import java.lang.*;
import java.io.*;
import java.util.*;


public class ToggleChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(toggleChar(str));

    }

    public static String toggleChar(String s){
        StringBuilder sb = new StringBuilder(s);
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                char uch = (char)('A'+ ch - 'a');
                sb.setCharAt(i, uch);
            }else if(ch >='A' && ch <= 'Z'){
                char lch = (char)('a' + ch - 'A');
                sb.setCharAt(i, lch);
            }
        }
        return sb.toString();
    }
}
