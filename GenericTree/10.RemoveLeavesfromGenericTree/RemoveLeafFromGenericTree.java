import java.util.*;

public class RemoveLeafFromGenericTree {
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
        removeLeafFromGenericTree(root);
        display(root);
    }

    public static void display(Node node){
        Queue<Node> mainQueue = new ArrayDeque<>();
        Queue<Node> childQueue = new ArrayDeque<>();

        mainQueue.add(node);

        while(mainQueue.size() > 0){
            node = mainQueue.poll();
            System.out.print(node.data+ " ");
            
            for(Node child : node.children){
                childQueue.add(child);
            }

            if( mainQueue.size() == 0){
                mainQueue = childQueue;
                childQueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public static void removeLeafFromGenericTree(Node node){

        //block 1 :
        for(int i= node.children.size() -1 ; i>=0; i--){
            Node child = node.children.get(i);
            if(child.children.size() == 0){
                node.children.remove(i);
            }
        }
        //block1 end

        //block 2
        for(Node child: node.children ){
            removeLeafFromGenericTree(child);
        }
        //block 2 end

        //Note: we need to remove the child in preorder , if removal is done in postorder , i.e, block 1 is written after block 2, we will not get right answer.
    }
}
