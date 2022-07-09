import java.util.*;

public class NodeToRootPath {
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
        System.out.println(find(root,37));
        for(Integer i: result){
            System.out.print(i+" ");
        }
        System.out.println(find(root, 38));
        System.out.println(find(root,70));
    }
    static ArrayList<Integer> result = new ArrayList<>();
    public static boolean find(Node node, int data){

        if(node == null){
            return false;
        }
        if(node.data == data){
            result.add(node.data);
            return true;
        }

       boolean filc = find(node.left, data);
       if(filc){
        result.add(node.data);
        return true;
       }

       boolean firc = find(node.right, data);
       if(firc){
        result.add(node.data);
        return true;
       }

        return false;
    }
}
