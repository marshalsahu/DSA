import java.util.*;

public class FindKthLargest {
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
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        int result = kthLargest(root, 4);
        System.out.println( " kth largest is "+ result);

    }
    public static int ceil;
    public static int floor;

    //find predessor and successor in preorder traversal
    public static void ceilAndFloor(Node node, int data){

        if(node.data > data){
            if(node.data < ceil){
                ceil = node.data;
            }
        }

        if(node.data < data){
            if(node.data > floor){
                floor = node.data;
            }
        }

        for(Node child : node.children){
            ceilAndFloor(child, data);
        }
    }

    public static int kthLargest(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;

        for(int i=0; i < k; i++ ){
            ceilAndFloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }

        return factor;
    }
}
