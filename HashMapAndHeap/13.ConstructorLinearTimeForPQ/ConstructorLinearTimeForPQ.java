import java.util.ArrayList;

public class ConstructorLinearTimeForPQ {
    public static class PriorityQueue{
        ArrayList<Integer> list = new ArrayList<>();

        public PriorityQueue(int[] arr){
            list = new ArrayList<>();
            for(int val : arr){
                list.add(val);
            }

            for(int i= list.size()/2-1 ; i >= 0;i--){
                downheapify(i); //we are using downheapify becoz its time complexity is O(n),where as in upheapify it takes O(nlogn).
            }

            // upheapify way of adding element to PQ.
            // for(int val:arr){
            //     this.add(val);
            // }
        }

        public int size(){
            return list.size();
        }

        public int peek(){
            if(list.size() == 0){
                System.out.println("underflow");
                return -1;
            }
            return list.get(0);
        }

        public void add(int val){
            list.add(val);

            upheapfiy(list.size()-1);
        }

        private void upheapfiy(int index){
            if(index == 0){
                return;
            }

            int pi = (index-1)/2;
            if (list.get(index) < list.get(pi)){
                swap(index,pi);
                upheapfiy(pi);
            }
        }

        private void swap(int i, int j){
            int ith = list.get(i);
            int jth = list.get(j);
            list.set(i, jth);
            list.set(j, ith);
        }

        public int remove(){
            if(list.size() == 0){
                System.out.println("underflow");
                return -1;
            }
            swap(0, list.size()-1);
            int data = list.remove(list.size()-1);
            downheapify(0);
            return data;
        }

        private void downheapify(int pi){
            int mini = pi;
            int leftChildi = 2 * pi + 1;
            if( leftChildi < list.size() && list.get(leftChildi) < list.get(pi)){
                mini = leftChildi;
            }

            int rightChildi = 2 * pi + 2;
            if( rightChildi < list.size() && list.get(rightChildi) < list.get(pi)){
                mini = rightChildi;
            }

            if( pi != mini){
                swap(pi,mini);
                downheapify(mini);
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20,1,34,22,72};
        PriorityQueue pq = new PriorityQueue(arr);
      
        System.out.println(pq.peek());
        System.out.println(pq.remove());
     
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.size());
    }
}
