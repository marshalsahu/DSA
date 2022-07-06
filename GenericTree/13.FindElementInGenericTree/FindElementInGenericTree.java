import java.util.*;;
public class FindElementInGenericTree {
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
        System.out.println(findElement(root, 75));
        System.out.println(findElement(root, 100));
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

    public static boolean findElement(Node node, int data){
        if(node.data == data){
            return true;
        }

        for(Node child: node.children){
            boolean firstChild = findElement(child, data);
            if(firstChild){
                return true;
            }
        }

        return false;
    }
}
