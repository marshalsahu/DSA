public class NormalQueue {
    
    public static class NQueue{
        int[] data;
        int front;
        int size;

        NQueue(int cap){
            data = new int[cap];
            front = 0;
            size = 0;
        }

        // public void add(int val){
        //     if(size == data.length){
        //         System.out.println("Queue Overflow");
        //     }else{
        //         int rear = (front + size) % data.length;
        //         data[rear] = val;
        //         size++;
        //     }
            
        // }

        //dynamic queue
        public void add(int val){
            if(size == data.length){
                int[] nqueue = new int[2 * data.length];
                for(int i = 0 ; i < data.length; i++){
                    nqueue[i] = data[i];
                }
                data = nqueue;
                int rear = ( front + size ) % data.length;
                data[rear] = val;
                size++;
            }else{
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
            
        }

        public void display(){
            for(int i = 0; i < size; i++){
                System.out.print(data[(front+i)%data.length]+ " ");
            }
            System.out.println();
        }

        public int remove(){
            if( size == 0){
                System.out.println("No data to remove");
                return -1;
            }else{
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        public int peek(){
            if( size == 0){
                System.out.println("Queue overflow");
                return -1;
            }else{
                return data[front];
            }
        }
    }
    public static void main(String[] args) {
        NQueue q = new NQueue(4);
        q.add(2);
        q.add(4);
        q.add(6);
        q.add(8);
        q.display();
        q.add(10);
        q.display();
        System.out.println(q.peek());
        q.remove();
        q.add(12);
        q.display();
        q.remove();
        q.remove();
        q.display();
        q.remove();
        q.display();
        q.remove();
    }
}
