import java.util.Scanner;
import java.util.Stack;

public class NextSmallerEleemntOnRight {
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
        // we are traversing right to left and doing 3 steps
        // 1step : -
        // 2step : add
        // 3step : +
        int[] nse = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        nse[arr.length -1] = -1;
        st.push(arr[arr.length -1]);
        for(int i= arr.length -2 ; i >= 0 ; i--){
            while( st.size() > 0 && st.peek() > arr[i]){
                st.pop();
            }

            if( st.size() == 0){
                nse[i] = -1;
            }else{
                nse[i] = st.peek();
            }

            st.push(arr[i]);
        }
        

        return nse;
    }


    public static int[] solution2(int[] arr){
        // we will traverse left to right and use store index of array in stack
        // it will pop greater element present in case it encouter smaller element and set nge with the poped element
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        st.push(0);

        for(int i=1; i< arr.length; i++){
            while(st.size() > 0 && arr[i] < arr[st.peek()]){
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
