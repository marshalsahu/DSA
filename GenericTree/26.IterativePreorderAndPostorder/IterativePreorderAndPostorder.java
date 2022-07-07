import java.util.*;

import javax.swing.RootPaneContainer;

public class IterativePreorderAndPostorder {
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
        iterativePreorderAndPostorder(root);
    }
    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.state = state;
            this.node = node;
        }
    }
    public static void iterativePreorderAndPostorder(Node node){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));

        String pre = "";
        String post = "";
        while(st.size() > 0){
            Pair top = st.peek();

            if(top.state == -1){
                pre += top.node.data+ " ";
                top.state++;
            }else if(top.state == top.node.children.size()){
                post += top.node.data + " ";
                st.pop();
            }else{
                Pair cp = new Pair(top.node.children.get(top.state), -1);
                st.push(cp);
                top.state++;
            }
        }

        System.out.println("preorder is "+pre);
        System.out.println("postorder is "+post);
    }
}
