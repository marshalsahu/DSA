import java.lang.*;
import java.io.*;
import java.util.*;

public class StringCompression {

    public static String compression1(String s){
        
        StringBuilder  str = new StringBuilder();
        str.append(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            char current = s.charAt(i);
            char prev = s.charAt(i-1);

            if(current!=prev){
                str.append(current);
            }
        }
        return new String(str);
    }

    public static String compression2(String s){
        StringBuilder  str = new StringBuilder();
        str.append(s.charAt(0));
        int count = 1;
        for(int i=1; i<s.length(); i++){
            char current = s.charAt(i);
            char prev = s.charAt(i-1);

            if(current!=prev){
                str.append(count);
                str.append(current);
                count=1;
            }else{
                count+=1;
            }
        }
        str.append(count);
        return new String(str);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }
}
