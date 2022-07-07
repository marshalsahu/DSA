import java.util.*;


//ceil is smallest among larger, and floor is largest among smaller
public class CeilAndFloor {
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
        ceilAndFloor(root, 50);
        System.out.println("ceil is "+ceil);
        System.out.println("floor is "+ floor);

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
}
