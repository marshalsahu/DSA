import java.util.*;
public class IterableIteratorGenericTree {
    
    public static class GenericTree implements Iterable<Integer>{
        Node node;
        GenericTree(Node node){
            this.node = node;
        }

        public Iterator<Integer> iterator(){
            Iterator<Integer> obj = new GTPreorderIterator(node);
            return obj;
        }
    }

    public static class GTPreorderIterator implements Iterator<Integer> {
        Integer nval;
        Stack<Pair> st ;

        public GTPreorderIterator(Node node){
            st = new Stack<>();
            st.push(new Pair(node, -1));
            next();
        }
        //whether new value is available or not
        public boolean hasNext(){
            if( nval == null){
                return false;
            }else{
                return true;
            }
        }

        //returns current value and sets up for next value
        public Integer next(){
            Integer forReturn = nval;

            nval = null;
            while(st.size() > 0){
                Pair top = st.peek();
                if(top.state == -1){
                    nval = top.node.data;
                    top.state++;
                    break;
                }else if( top.state >= 0 && top.state < top.node.children.size() ){
                    Pair cp  = new Pair(top.node.children.get(top.state), -1);
                    st.push(cp);
                    top.state++;
                }else{
                    st.pop();
                }
            }
            return forReturn;
        }
    }

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
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
        GenericTree gt = new GenericTree(root);
        for(int val: gt){
            System.out.println(val);
        }

        // Iterator<Integer> gti = gt.iterator();
        // while(gti.hasNext()){
        //     System.out.println(sti.next());
        // }
    }

    public static void display(Node node){
        String s = node.data + " -> ";

        for(Node child : node.children){
            s += child.data + " , ";
        }
        s += ".";

        System.out.println(s);

        for(Node child : node.children){
            display(child);
        }
    }
}
