import java.util.*;

public class PrintAllPalindromicSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        printAllPalindromicSubstring(s);
    }

    public static void printAllPalindromicSubstring(String str){

        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                String substr = str.substring(i, j);
                if( isPalindrome(substr) == true){
                    System.out.println(substr);
                }
            }
        }
    }


    public static boolean isPalindrome(String s){

        int start = 0;
        int end = s.length()-1;

        while(start <= end){
            char first = s.charAt(start);
            char last = s.charAt(end);

            if(first != last){
                return false;
            }else{
                start++;
                end--;
            }
        }

        return true;
    }
}
