
import java.util.*;
public class TiltBinaryTree {
    public static class Node{
        int data;
        Node right;
        Node left;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null, 37,30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1) ; //1 : leftpush, 2: rightpush, 3: pop
        st.push(rootPair);
        int idx = 0;
        while(st.size() > 0){
            Pair top = st.peek();
  
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    Node leftNode = new Node(arr[idx], null, null);
                    top.node.left = leftNode;
                    
                    Pair leftPair = new Pair(leftNode, 1);
                    st.push(leftPair);
                }else{
                    top.node.left= null;
                }
                top.state++;

            }else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    Node rightNode = new Node(arr[idx], null, null);
                    top.node.right = rightNode;
                    Pair rightPair = new Pair(rightNode, 1);
                    st.push(rightPair);
                }else{
                    top.node.right = null;
                }
                top.state++;
            }else{
                st.pop();
            }
        }
        display(root);
        removeLeaves(root);
        display(root);
    }

    public static void display(Node node){

        if(node == null){
            return;
        }
        String s = "";
        s += node.left == null ? "-" : node.left.data + "";
        s += " -> "+node.data+" -> ";
        s += node.right == null ? "-" : node.right.data + "";

        System.out.println(s);
        display(node.left);
        display(node.right);
    }

    public static int tiltVal = 0;
    public static int tilt(Node root){
        if(root == null){
            return 0;
        }
        int ltilt = tilt(root.left);
        int rtilt = tilt(root.right);

        tiltVal += Math.abs(rtilt - ltilt);

        return ltilt + rtilt + root.data;
    }
}