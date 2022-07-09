import java.util.*;

public class PathToLeafFromRoot {
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
        pathToLeafFromRoot(root, "", 0, 0, 1400);
    }

             //                         50
                //              /                      \
                //          25                           75
                //      /        \                     /       \
                //   12            37                  62          87
                // /               /                       \
                //             30                          70
    //print path whose sum is >= ll and <= hl (lowerlimit and higherlimit)
    public static void pathToLeafFromRoot(Node node, String path, int sum, int ll, int hl){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            sum+=node.data;
            if( sum >= ll && sum <= hl){
                System.out.println(path+node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path+node.data+" ", sum+node.data, ll, hl);
        pathToLeafFromRoot(node.right, path+node.data+" ", sum+node.data, ll, hl);
    }
}
