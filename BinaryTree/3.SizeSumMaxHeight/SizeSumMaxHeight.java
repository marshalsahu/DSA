import java.util.*;

public class SizeSumMaxHeight {
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
        System.out.println(max(root));
        System.out.println(size(root));
        System.out.println(height(root));
        System.out.println(sum(root));
        
    }

    public static int size(Node node){
        if(node == null){
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls+rs+1;
        return ts;
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls + rs + node.data;

        return ts;
    }

    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        int lm = max(node.left);
        int rm = max(node.right);

        int max = Math.max(node.data, Math.max(lm, rm));

        return max;
    }


    public static int height(Node node){
        if(node == null){
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) +1;
        return th;
    }
}
