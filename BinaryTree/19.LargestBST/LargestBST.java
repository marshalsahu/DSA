import java.util.*;
public class LargestBST {
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
        // removeLeaves(root);
        // display(root);
        BSTPair answer = isBST(root);
        System.out.println("is bst "+ answer.isBST);
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


    //solution
    public static class BSTPair{
        boolean isBST;
        int min;
        int max;
        Node lbstNode;
        int lbstSize;
    }

    public static BSTPair isBST(Node root){

    if(root == null){
        BSTPair bp = new BSTPair();
        bp.isBST = true;
        bp.max = Integer.MIN_VALUE;
        bp.min = Integer.MAX_VALUE;
        bp.lbstNode = null;
        bp.lbstSize = 0;
        return bp;
    }

    BSTPair lp = isBST(root.left);
    BSTPair rp = isBST(root.right);
    BSTPair mp = new BSTPair();
    mp.isBST = lp.isBST && rp.isBST;
    mp.max = Math.max(root.data, Math.max(lp.max, rp.max));
    mp.min = Math.min(root.data, Math.min(lp.min, rp.min));
    if(mp.isBST){
        mp.lbstNode = root;
        mp.lbstSize = lp.lbstSize + rp.lbstSize + 1;
    }else if( lp.lbstSize > rp.lbstSize){
        mp.lbstNode = lp.lbstNode;
        mp.lbstSize = lp.lbstSize;
    }else{
        mp.lbstNode = rp.lbstNode;
        mp.lbstSize = rp.lbstSize;
    }
    return mp;
    }
}

