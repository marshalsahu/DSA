import java.util.*;
public class BalancedBinaryTree {
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

    //int solution 1
    public static boolean isBST = true;
    public static int balancedBT(Node root){

        if(root == null){
            return 0;
        }
        
        int lh = balancedBT(root.left);
        int rh = balancedBT(root.right);

        if( Math.abs(lh -rh )> 1){
            isBST = false;
        }

        int th = Math.max(lh, rh) + 1;

        return th;
    }


    //solution 2

    public static class BalPair{
        boolean isBal;
        int ht;
    }

    public static BalPair isBalanced(Node root){
        if(root == null){
            BalPair bp = new BalPair();
            bp.ht = 0;
            bp.isBal = true;
            return bp;
        }

        BalPair lp = isBalanced(root.left);
        BalPair rp = isBalanced(root.right);

        BalPair mp = new BalPair();
        mp.isBal = Math.abs(lp.ht - rp.ht) > 1 && lp.isBal && rp.isBal;
        mp.ht = Math.max(lp.ht, rp.ht)+1;
        return mp;
    }
}
