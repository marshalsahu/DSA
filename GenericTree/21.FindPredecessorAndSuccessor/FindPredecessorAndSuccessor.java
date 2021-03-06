import java.util.*;

public class FindPredecessorAndSuccessor {
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
        predecessor = null;
        successor = null;
        findPredecessorAndSuccessor(root,80);
        System.out.println("predessor is "+ predecessor.data);
        System.out.println("successor is "+ successor.data);

    }
    public static Node predecessor;
    public static Node successor;
    public static int state;
    //find predessor and successor in preorder traversal
    public static void findPredecessorAndSuccessor(Node node, int data){
        
        if(state == 0){
            if(node.data == data){
                state = 1;
            }else{
                predecessor = node;
            }
        }else if(state == 1){
            successor = node;
            state = 2;
        }
        for(Node child: node.children){
            findPredecessorAndSuccessor(child,data);
        }

    
    }
}
