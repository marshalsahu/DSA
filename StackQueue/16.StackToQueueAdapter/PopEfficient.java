import java.util.Stack;

public class PopEfficient {
    
    public static class MyQueue{
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> helperStack = new Stack<>();

        public void add(int val){
            while(mainStack.size() > 0){
                helperStack.push(mainStack.pop());
            }
            mainStack.push(val);
            while(helperStack.size() > 0){
                mainStack.push(helperStack.pop());
            }
        }

        public int top(){
            if(size() == 0){
                System.out.println("underflow");
                return -1;
            }
            return mainStack.peek();
        }

        public int pop(){
            if(size() == 0){
                System.out.println("underflow");
                return -1;
            }
            return mainStack.pop();
        }

        public int size(){
            return mainStack.size();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.top());
        q.pop();
        System.out.println(q.top());
    }
}
