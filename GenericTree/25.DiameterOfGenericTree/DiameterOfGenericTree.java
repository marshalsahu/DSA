import java.util.*;

public class DiameterOfGenericTree {
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
        calculateDiaReturnHeight(root);
        System.out.println("diameter is "+dia);
    }

    static int dia= 0;

    static int calculateDiaReturnHeight(Node node){
        int dch = -1; //deepest child height
        int sdch = -1; //second deepest child height

        for(Node child : node.children){
            int ch =calculateDiaReturnHeight(child);

            if( ch > dch){
                sdch = dch;
                dch = ch;
            }else if( ch > sdch){
                sdch = ch;
            }
        }

        if( dch + sdch +2 > dia){
            dia = dch + sdch +2;
        }

        dch+=1;
        return dch;
    }
}
