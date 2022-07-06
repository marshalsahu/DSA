import java.util.ArrayList;
import java.util.Stack;


public class HeightOfGenericTree {
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

        System.out.println("height of tree is "+getHeight(root));
    }

    public static int getHeight(Node node){
        //taking ht as -1 coz we are counting height based on edges. and for single node tree, height should be 0.
        int ht = -1;

        for(Node child : node.children){
            int currentHeight = getHeight(child);
            ht = Math.max(ht, currentHeight);
        }

        ht += 1;

        return ht;
    }
}
