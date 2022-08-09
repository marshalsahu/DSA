import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] ngeOnRight = new int[n];
        ngeOnRight[arr.length-1] = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }

            if(st.size() == 0){
                ngeOnRight[i] = arr.length;
            }else{
                ngeOnRight[i] = st.peek();
            }
            st.push(i);
        }

        for(int i = 0; i <= arr.length - k; i++){
            int j = i;
            while( ngeOnRight[j] < i+k){
                j = ngeOnRight[j];
            }
            System.out.println(arr[j]);
        }
    }
}
