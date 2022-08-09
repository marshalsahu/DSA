import java.util.Stack;

public class MinStack {
    public static class MStack{
        Stack<Integer> aStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int val){
            aStack.push(val);

            if(minStack.size() == 0 || minStack.peek() >= val){
                minStack.push(val);
            }
        }


        public int top(){
            return aStack.peek();
        }

        public int pop(){
            if(size() == 0){
                System.out.println("underflow");
                return -1;
            }else{
                int val = aStack.pop();

                if(minStack.peek() == val){
                    minStack.pop();
                }
            return val;
            }
        }   

        public int min(){
            if(size() == 0){
                System.out.println("underflow");
                return -1;
            }else{
                return minStack.peek();
            }
        }

        public int size(){
            return aStack.size();
        }
    }

    public static void main(String[] args) {
        MStack s = new MStack();
        s.push(10);
        s.push(20);
        System.out.println(s.min());
        s.pop();
        s.pop();
        System.out.println(s.min());
        
    }
}
