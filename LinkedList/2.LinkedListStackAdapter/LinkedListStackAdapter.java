import java.util.LinkedList;

public class LinkedListStackAdapter {
    public static class LLToStackAdapter{
        LinkedList<Integer> llist;

        public LLToStackAdapter(){
            llist = new LinkedList<>();
        }

        int size(){
            return llist.size();
        }

        void push(int data){
            llist.addFirst(data);
        }

        int top(){
            if( size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                return llist.getFirst();
            }
        }

        int pop(){
            if( size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                return llist.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        LLToStackAdapter llist = new LLToStackAdapter();
        llist.push(30);
        llist.push(40);
        llist.push(50);
        System.out.println(llist.pop());
        llist.push(60);
        System.out.println(llist.top());
        System.out.println(llist.top());
    }
}
