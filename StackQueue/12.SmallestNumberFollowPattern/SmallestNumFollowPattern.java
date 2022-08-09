import java.util.Scanner;
import java.util.Stack;
public class SmallestNumFollowPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int num = 1;
        Stack<Integer> st = new Stack();
        for(int i = 0; i < s.length(); i++ ){
            char ch = s.charAt(i);

            if( ch == 'd'){
                st.push(num);
                num++;
            }else{
                st.push(num);
                num++;
                while(st.size() > 0){
                    System.out.print(st.pop() + "   ");
                }
            }
        }
        while(st.size() > 0){
            System.out.print(st.pop() + "   ");
        }

    }
}
