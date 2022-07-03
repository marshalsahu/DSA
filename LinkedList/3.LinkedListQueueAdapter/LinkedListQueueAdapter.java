import java.util.LinkedList;

public class LinkedListQueueAdapter {
    public static class LLToQueueAdapter{
        LinkedList<Integer> llist;

        public LLToQueueAdapter(){
            llist = new LinkedList<>();
        }

        int size(){
            return llist.size();
        }

        void add(int val){
            llist.addLast(val);
        }

        int remove(){
            return llist.removeFirst();
        }

        int peek(){
            return llist.getFirst();
        }
    }

    public static void main(String[] args) {
        LLToQueueAdapter llist = new LLToQueueAdapter();
        llist.add(10);
        llist.add(20);
        llist.add(30);
        System.out.println(llist.peek());
        llist.add(40);
        llist.add(50);
        System.out.println(llist.peek());
        System.out.println(llist.remove());
        System.out.println(llist.peek());
    }
}
