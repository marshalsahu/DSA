import java.util.Stack;

public class PushEfficient {
    public static class MyQueue{
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> helperStack = new Stack<>();

        public void push(int val){
            mainStack.push(val);
        }

        public int top(){
            if(size() == 0){
                System.out.println("underflow");
                return -1;
            }else{
                while(mainStack.size() > 1){
                    helperStack.push(mainStack.pop());
                }
                int val = mainStack.pop();
                helperStack.push(val);
                while(helperStack.size() > 0){
                    mainStack.push(helperStack.pop());
                }
                return val;
            }
        }

        public int pop(){
            if(size() == 0){
                System.out.println("underflow");
                return -1;
            }else{
                while(mainStack.size() > 1){
                    helperStack.push(mainStack.pop());
                }
                int val = mainStack.pop();
                while(helperStack.size() > 0){
                    mainStack.push(helperStack.pop());
                }
                return val;
            }
        }

        public int size(){
            return mainStack.size();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.top());
        q.pop();
        System.out.println(q.top());
    }
}
