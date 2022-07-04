import java.util.Stack;
import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> st = new Stack<>();

        for(int i=0; i < s.length(); i++){

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }else if(s.charAt(i) == ')' ){
                if (st.size() == 0){
                    System.out.println("false");
                    return;
                }else{
                    if ( !handlingClosing(st, '(')){
                        System.out.println("false");
                        return;
                    }
                }

            }else if(s.charAt(i) == '}' ){
                if (st.size() == 0){
                    System.out.println("false");
                    return;
                }else{
                    if ( !handlingClosing(st, '{')){
                        System.out.println("false");
                        return;
                    }
                }

            }else if(s.charAt(i) == ']' ){
                if (st.size() == 0){
                    System.out.println("false");
                    return;
                }else{
                    if ( !handlingClosing(st, '[')){
                        System.out.println("false");
                        return;
                    }
                }
            }
        }

        if(st.size() == 0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
        
    public static boolean handlingClosing(Stack<Character> st, Character correspondingOpenChar) {

        if (st.peek() != correspondingOpenChar){
            return false;
        }else{
            st.pop();
            return true;
        }

        
        
    }
    
}
