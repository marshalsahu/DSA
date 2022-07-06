import java.util.*;;

public class LowestCommonAncestor {
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

        System.out.println(lowestCommonAncestor(root, 110, 120));
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


    public static int lowestCommonAncestor(Node node,int d1, int d2){
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i=p1.size() -1;
        int j = p2.size() -1;

        while( i >= 0 && j>=0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }

        i++;
        j++;

        return p1.get(i);

    }
}
