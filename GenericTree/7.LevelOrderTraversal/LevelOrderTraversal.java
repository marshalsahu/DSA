import java.util.*;

public class LevelOrderTraversal {
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
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(Node node){
        //RPA : remove , print , addchildren
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while(queue.size() > 0){
            node = queue.remove();
            System.out.print(node.data+ " ");

            for(Node child : node.children){
                queue.add(child);
            }
        }
    }
}
