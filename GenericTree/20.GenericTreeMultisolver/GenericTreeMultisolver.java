import java.util.*;

public class GenericTreeMultisolver {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1,  120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Stack<Node> st = new Stack<>();
        Node root = null;

        for(int i=0; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node t = new Node();
                t.data = arr[i];

                if( st.size() > 0){
                    st.peek().children.add(t);
                }else{
                    root = t;
                }
                st.push(t);
            }
        }

        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;

        System.out.println(" size : "+ size);
        System.out.println(" min  : "+ min);
        System.out.println(" max : "+ max);
        System.out.println(" height : "+ height);

        multiSolver(root, 0);
        System.out.println(" size : "+ size);
        System.out.println(" min  : "+ min);
        System.out.println(" max : "+ max);
        System.out.println(" height : "+ height);
    }

    static int size;
    static int max;
    static int min;
    static int height;
    // it uses travel and change strategy
    public static void multiSolver(Node node, int depth){
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);

        for(Node child : node.children){
            multiSolver(child, depth+1);
        }
        
    }
}