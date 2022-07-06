import java.util.ArrayList;
import java.util.Stack;

public class TraversalGenericTree {
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
        traversal(root);
    }

    public static void traversal(Node node){
        //euler's left , on the way deep in recursion , node's pre area
        System.out.println("Node Pre "+ node.data);

        for( Node child : node.children){
            //edge pre
            System.out.println(" Edge Pre "+node.data + "---> " + child.data);
            traversal(child);

            //edge post
            System.out.println("Edge Post "+ node.data+ "---> "+ child.data);
        }
        //euler's right, on the way out of recursion, node's post area 
        System.out.println("Node post "+ node.data);
    }
}
