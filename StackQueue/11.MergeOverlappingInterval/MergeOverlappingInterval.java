import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class MergeOverlappingInterval {

    public static class Pair implements Comparable<Pair>{
        int start;
        int end;

        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair o){
            if( this.start != o.start){
                return this.start - o.start;
            }else{
                return this.end - o.end;
            }
        }
    }

    public static void mergeOverlappingInterval(int[][] arr) {

        Pair[] pairs = new Pair[arr.length];
        for(int i = 0; i < arr.length; i++){
            int st = arr[i][0];
            int end = arr[i][1];
            pairs[i] = new Pair(st, end);
        }

        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        for(int i=0; i<pairs.length; i++){
            if(i == 0){
                st.push(pairs[i]);
            }else{
                Pair p = st.peek();

                if( p.end >= pairs[i].start){
                    //we need to merge
                    if( p.end >= pairs[i].end ){
                        //nothing
                    }else{
                        p.end = Math.max(p.end, pairs[i].end);
                    }
                }else{
                    st.push(pairs[i]);
                }
            }
        }

        Stack<Pair> res = new Stack<>();
        while(st.size() > 0){
            res.push(st.pop());
        }
        while(res.size() > 0){
            Pair top = res.pop();
            System.out.println(top.start + "    "+ top.end);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        mergeOverlappingInterval(arr);
    }
}
