import java.util.*;

public class MedianPriorityQueue {
    public static class MedianPQ{
        PriorityQueue<Integer> left ;
        PriorityQueue<Integer> right ;

        public MedianPQ(){
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val){
            if(right.size() > 0 && right.peek() < val){
                right.add(val);
            }else{
                left.add(val);
            }

            if(right.size() -left.size() == 2){
                left.add(right.remove());
            }else if(left.size() - right.size() == 2){
                right.add(left.remove());
            }
        }

        public int remove(){
            if(this.size() == 0 ){
                System.out.println("underflow");
                return -1;
            }else if( left.size() >= right.size()){
                return left.remove();
            }else{
                return right.remove();
            }
        }

        public int peek(){
            if(this.size() == 0){
                System.out.println("underflow");
                return -1;
            }else if( left.size() >= right.size()){
                return left.peek();
            }else{
                return right.peek();
            }
        }

        public int size(){
            return left.size() + right.size();
        }
       
    }
    public static void main(String[] args) {
        MedianPQ mq = new MedianPQ();
        mq.add(10);
        mq.add(20);
        mq.add(40);
        mq.add(70);
        mq.add(30);
        System.out.println(mq.peek());
        mq.remove();
        System.out.println(mq.peek());
    }
}
