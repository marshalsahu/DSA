import java.util.Collections;
import java.util.PriorityQueue;
public class KLargestElement {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //it will prioritise min element
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); - it will prioritise max element
        int[] arr  = { 12, 223, 13, 54, 75,1, 665, 22, 45, 57};

        for(int val : arr){
            pq.add(val);
        }
        int k = 3;
        while(k > 0){
            System.out.println(pq.peek());
            pq.remove();
            k--;
        }
    }
    // spacecomplexity is O(n)
}
