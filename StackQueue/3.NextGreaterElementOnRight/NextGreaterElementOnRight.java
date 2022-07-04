import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementOnRight {

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

        int[] result = solution2(arr);
        display(arr);
        display(result);

        sc.close();
    }

    public static int[] solution(int[] arr){
        // we are traversing right to left and doing 3 steps
        // 1step : -
        // 2step : answer
        // 3step : +
        int[] nge = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        nge[arr.length-1] = -1;
        st.push(arr[arr.length-1]);

        for(int i=arr.length-2; i>=0; i--){
            
            while(st.size() > 0 && arr[i] > st.peek()){
                st.pop();
            }
            
            if(st.size() > 0){
                nge[i] = st.peek();
            }else{
                nge[i] = -1;
            }

            st.push(arr[i]);
        }

        return nge;
    }


    public static int[] solution2(int[] arr){
        // we will traverse left to right and use store index of array in stack
        // it will pop element smaller to it and also become the answer to the index which it is poping out
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        st.push(0);
        for(int i=0; i < arr.length; i++){
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                int pos = st.peek();
                nge[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0){
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }
       

        return nge;
    }
}
