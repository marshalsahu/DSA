import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int[] nseOnLeft = new int[n];
        int[] nseOnRight = new int[n];

        nseOnLeft[0] = -1;
        Stack<Integer> st = new Stack<>();
        for(int i = 1; i < n; i++){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.size() == 0){
                nseOnLeft[i] = -1;
            }else{
                nseOnLeft[i] = st.peek();
            }
            st.push(i);
        }
        nseOnRight[arr.length-1] = arr.length; // it will help to calculate area
        Stack<Integer> str = new Stack<>();
        for(int i = arr.length-2; i >= 0; i--){
            while( str.size() > 0 && arr[str.peek()] > arr[i]){
                str.pop();
            }

            if(str.size() == 0){
                nseOnRight[i] = arr.length;
            }else{
                nseOnRight[i] = str.peek();
            }

            str.push(i);
        }

        int max_area = 0;
        for(int i = 0; i < arr.length; i++){
            int width = nseOnRight[i] - nseOnLeft[i] - 1;
            int area = arr[i] * width;

            if ( area > max_area){
                max_area = area;
            }
        }
  
        System.out.println("Max area is "+max_area);
    }
}
