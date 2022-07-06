import java.util.*;

public class LevelOrderLinewiseZigZag {
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

        levelOrderLinewiseZZ(root);
    }

    public static void levelOrderLinewiseZZ(Node node){
        Stack<Node> mainStack = new Stack<>();
        Stack<Node> childStack = new Stack<>();

        int level = 1;
        mainStack.push(node);

        while(mainStack.size() > 0){
            node = mainStack.pop();

            System.out.print(node.data+ " ");
            
            if(level%2 == 1){
                for(int i=0; i<node.children.size(); i++){
                    childStack.add(node.children.get(i));
                }
            }else{
                for(int i=node.children.size()-1; i>=0; i--){
                    childStack.add(node.children.get(i));
                }
            }

            if(mainStack.size() == 0){
                mainStack = childStack;
                childStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
}
