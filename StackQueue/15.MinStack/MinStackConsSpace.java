import java.util.Stack;

public class MinStackConsSpace {
    public static class MStack{
        Stack<Integer> s = new Stack<>();
        int min = 0;

        public void push(int val){
            if(s.size() == 0){
                s.push(val);
                min = val;
            }else if( val >= min){
                s.push(val);
            }else{
                s.push(val+val-min);
                min = val;
            }
        }

        public int top(){
            if( s.size() == 0){
                System.out.println("underflow");
                return -1;
            }else if(s.peek() >= min){
                return s.peek();
            }else{
                return min;
            }
        }

        public int pop(){
            if( s.size() == 0){
                System.out.println("underflow");
                return -1;
            }else {
                int val = s.pop();
                if(val >= min){
                    return val;
                }else{
                    
                    int currentMin = min;
                    min = 2 * min - val;    
                    return currentMin;
                }
            }
        }

        public int min(){
            if(s.size() == 0 ){
                System.out.println("underflow");
                return -1;
            }else{
                return min;
            }
        }

        public int size(){
            return s.size();
        }
    }
}
