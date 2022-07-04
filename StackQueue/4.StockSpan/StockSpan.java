import java.util.*;

public class StockSpan {
    public static void display(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int[] result = solution(arr);
        display(arr);
        display(result);

        sc.close();
    }

    public static int[] solution(int[] arr){
        int[] span = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(0);
        span[0] = 1;

        for(int i=1; i< arr.length; i++){
            while( st.size() > 0 && arr[i] > arr[st.peek()]){
                st.pop();
            }

            if( st.size() == 0){
                span[i] = i+1;
            }else{
                span[i] = i - st.peek();
            }

            st.push(i);
        }

        return span;
    }
}
