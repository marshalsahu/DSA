import java.util.*;
public class DiameterBinaryTree {
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

    public static int height(Node root){
        if(root == null){
            return -1;
        }
        int height = -1;
        int lh = height(root.left);
        int rh = height(root.right);
        height = Math.max(height, Math.max(lh, rh));

        return height+1;
    }

    //inefficient approach
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int dl = diameter(root.left);
        int dr = diameter(root.right);

        int lh = height(root.left);
        int rh = height(root.right);
        int maxdiameter = Math.max(lh+rh+2, Math.max(dl, dr));
        return maxdiameter;
    }

    //efficient approach
    public static class DiaPair{
        int height;
        int dia;
    }

    public static DiaPair diameter2(Node root){
        if(root== null){
            DiaPair nd = new DiaPair();
            nd.height = -1;
            nd.dia = 0;
            return nd;
        }

        DiaPair ld = diameter2(root.left);
        DiaPair rd = diameter2(root.right);

        DiaPair nd = new DiaPair();
        nd.height = Math.max(ld.height, rd.height) +  1;
        int diam = ld.height + rd.height + 2;
        nd.dia = Math.max(diam, Math.max(ld.dia, rd.dia));
        return nd;
    }
}