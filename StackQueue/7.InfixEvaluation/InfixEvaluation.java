import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Integer> stOperand = new Stack<>();
        Stack<Character> stOperator = new Stack<>();

        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            System.out.println("working on ch "+ch);
            if(ch == '('){
                stOperator.push(ch);
            }else if(Character.isDigit(ch)){
                stOperand.push(ch-'0');
            }else if(ch == ')'){    

                while(stOperator.size() > 0 && stOperator.peek() != '('){
                    char optr = stOperator.pop();
                    int v2 = stOperand.pop();
                    int v1 = stOperand.pop();
                    System.out.println("operation is b/w "+v1+"-> "+v2+"---"+optr);
                    int result = operation(v1, v2, optr);
                    stOperand.push(result);
                }

                stOperator.pop();

            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                //ch is wanting higher priority elements to solve first
                while(stOperator.size() > 0 && stOperator.peek() == '(' && precedence(ch) <= precedence(stOperator.peek())){
                    char optr = stOperator.pop();
                    int v2 = stOperand.pop();
                    int v1 = stOperand.pop();
                    System.out.println("operation is b/w "+v1+"-> "+v2+"---"+optr);
                    int result = operation(v1, v2, optr);
                    stOperand.push(result);
                }
                stOperator.push(ch);
            }
        }

        while(stOperator.size() > 0){
            char optr = stOperator.pop();
            int v2 = stOperand.pop();
            int v1 = stOperand.pop();
            System.out.println("operation is b/w "+v1+"-> "+v2+"---"+optr);
            int result = operation(v1, v2, optr);
            stOperand.push(result);
        }

        System.out.println(stOperand.peek());


    }

    public static int precedence(char ch){
        if( ch == '('){
            return 0;
        }else if( ch == '+'){
            return 1;
        }else if( ch == '-'){
            return 1;
        }else if( ch == '*'){
            return 2;
        }else{
            return 2;
        }
    }   

    public static int operation(int v1, int v2, char ch){
        if( ch == '+'){
            return v1 + v2;
        }else if( ch == '-'){
            return v1 - v2;
        }else if( ch == '*'){
            return v1 * v2;
        }else{
            return v1 / v2;
        }
    }
}
