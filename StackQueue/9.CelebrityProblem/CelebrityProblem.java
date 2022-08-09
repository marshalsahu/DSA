import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    //member who is known by everybody and he knows no one.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr){

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            st.push(i);
        }

        while(st.size() > 1){
            int person1 = st.pop();
            int person2 = st.pop();

            if( arr[person1][person2] == 1){
                //person1 knows person2 i.e, person1 can't be celebrity
                st.push(person2);
            }else{
                //person1 doesn't know person2 i.e, person2 can't be celebrity
                st.push(person1);
            }
        }

        int possibleCandidate = st.peek();
        boolean flag = true;
        for(int j = 0; j < arr[0].length; j++){
            if ( j != possibleCandidate){
                if(arr[possibleCandidate][j] == 1 || arr[j][possibleCandidate] == 0){
                    flag = false;
                    break;
                }
            }
            
        }

        if(flag){
            System.out.println("person "+possibleCandidate+ " is celebrity");
        }else{
            System.out.println("No celebrity found");
        }
    }
}
