import java.util.Scanner;
import java.util.Stack;

public class PostfixExpression {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        Stack<Integer> vstack = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if( ( ch >= '0' && ch <= '9') 
                        || ( ch >= 'a' && ch <= 'z')
                        || ( ch >= 'A' && ch <= 'Z')){

                vstack.push(ch-'0');
                prefix.push(ch+"");
                infix.push(ch+"");
                    
             }else if ( ch == '+' || ch == '-' || ch == '*' || ch == '/'){
             
                int v2 = vstack.pop();
                int v1 = vstack.pop();
                int res = performOperation(v1, v2 , ch);
                vstack.push(res);

                String prev2 = prefix.pop();
                String prev1 = prefix.pop();
                String prev = ch + prev1 + prev2;
                prefix.push(prev);
                

                String infv2 = infix.pop();
                String infv1 = infix.pop();
                String infv = "(" + infv1 + ch + infv2 + ")";
                infix.push(infv);
            }

        }

        System.out.println(vstack.peek());
        System.out.println("infix exp is -->  "+ infix.peek());
        System.out.println("prefix exp is -->  "+ prefix.peek());
    }

    public static int performOperation(int v1, int v2, char ch){
        if ( ch == '+'){
            return v1 + v2;
        }else if ( ch == '-'){
            return v1 - v2;
        }else if ( ch == '*'){
            return v1 * v2;
        }else {
            return v1 / v2;
        }
    }
}
