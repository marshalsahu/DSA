import java.util.ArrayList;

public class PQUsingHeap {
    
    public static class PriorityQueue{
        ArrayList<Integer> list = new ArrayList<>();

        public int size(){
            return list.size();
        }

        public int peek(){
            if(size() == 0){
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
        PriorityQueue pq = new PriorityQueue();
        pq.add(50);
        pq.add(30);
        pq.add(40);
        pq.add(35);
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        pq.add(10);
        pq.add(5);
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.size());
    }
}
