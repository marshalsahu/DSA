import java.lang.*;
import java.io.*;
import java.util.*;


public class StringWithAsciiDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(asciiDiff(str));
    }

    public static String asciiDiff(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            char current = s.charAt(i);
            char prev = s.charAt(i-1);

            int diff = current - prev;
            sb.append(diff);
            sb.append(current);
        }
        return sb.toString();
    }
}
