import java.util.*;


public class AreTreesSimilar {
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

        ArrayList<Integer> result = nodeToRootPath(root, 120);
        for(int res : result){
            System.out.print(res+" ");
        }
    }

    //expectation is : f(10,120) : will give path from node 120 to 10.
    //faith is : f(30,120) : will give path from node 120 to 30.
    //f -> e : add 10 to the path for f(30,120)
    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> llist = new ArrayList<>();
            llist.add(node.data);
            return llist;
        }

        for(Node child : node.children){
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, data);
            
            if(pathTillChild.size() > 0){
                pathTillChild.add(node.data);
                return pathTillChild;
            }
        }

        return new ArrayList<>();
    }

    public static boolean areTreesSimilar(Node a, Node b){

        if(a.children.size() != b.children.size()){
            return false;
        }

        for(int i=0; i<a.children.size(); i++){
            Node c1 = a.children.get(i);
            Node c2 = b.children.get(i);

            if (areTreesSimilar(c1, c2) == false){
                return false;
            }
        }

        return true;
    }
}
