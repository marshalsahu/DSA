import java.util.*;

public class LinearizeGenericTree {
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
        display(root);
        linearizeGenericTree(root);
        System.out.println("result is");
        display(root);
    }

    public static void display(Node node){
        String s = node.data + " -> ";

        for(Node child : node.children){
            s += child.data + " , ";
        }
        s += ".";

        System.out.println(s);

        for(Node child : node.children){
            display(child);
        }
    }
    
    public static void linearizeGenericTree(Node node){
        for(Node child : node.children){
            linearizeGenericTree(child);
        }

        while(node.children.size() > 1){
            Node lastChild = node.children.remove(node.children.size()-1);
            Node secondLast = node.children.get(node.children.size()-1);
            Node secondLastTail = getLast(secondLast);
            secondLastTail.children.add(lastChild);
        }
    }

    private static Node getLast(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }
}
