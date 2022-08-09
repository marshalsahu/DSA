import java.util.Scanner;
import java.util.Stack;

public class InfixConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String exp = sc.nextLine();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if( ch == '('){
                operator.push(ch);
            }else if( ( ch >= '0' && ch <= '9') 
                        || ( ch >= 'a' && ch <= 'z')
                        || ( ch >= 'A' && ch <= 'Z')){
                
                prefix.push(ch+"");
                postfix.push(ch+ "");

            }else if( ch == ')' ){

                while( operator.peek() != '(' ){
                    char op = operator.pop();
                    
                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postv = postv1 + postv2 + op;
                    postfix.push(postv);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String prev = op + prev1 + prev2;
                    prefix.push(prev);
                    
                }

                operator.pop();

            }else if ( ch == '+' || ch == '-' || ch == '*' || ch == '/'){

                while( operator.size() > 0 
                        &&  operator.peek() != '(' 
                        && precedence(ch) <= precedence(operator.peek())){

                    char op = operator.pop();
                    
                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postv = postv1 + postv2 + op;
                    postfix.push(postv);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String prev = op + prev1 + prev2;
                    prefix.push(prev);
                }
                operator.push(ch);

            }
        }

        while( operator.size() > 0 ){

            char op = operator.pop();
            String postv2 = postfix.pop();
            String postv1 = postfix.pop();
            String postv = postv1 + postv2 + op;
            postfix.push(postv);

            String prev2 = prefix.pop();
            String prev1 = prefix.pop();
            String prev = op + prev1 + prev2;
            prefix.push(prev);
        }

    }

    public static int precedence(char op){
        if(op == '+' || op == '-'){
            return 1;
        }else if( op == '*' || op == '/'){
            return 2;
        }else{
            return 0;
        }
    }
}
