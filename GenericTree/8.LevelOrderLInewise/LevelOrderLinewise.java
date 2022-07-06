import java.util.*;
public class LevelOrderLinewise {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(){}
        
        Node(int data){
            this.data = data;
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

        levelOrderLinewise4(root);
    }

    public static void levelOrderLinewise(Node node){

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

    //using delimiter aproach
    public static void levelOrderLinewise2(Node node){
        Queue<Node> mainQueue = new ArrayDeque<>();
        mainQueue.add(node);
        mainQueue.add(new Node(-1));

        while(mainQueue.size() > 0){
            node = mainQueue.remove();

            if(node.data == -1){
                if(mainQueue.size() > 0){
                    mainQueue.add(new Node(-1));
                    System.out.println();
                }
            }else{
                System.out.print(node.data + " ");

                for(Node child : node.children){
                    mainQueue.add(child);
                }
            }
        }
    }

    //using counter
    public static void levelOrderLinewise3(Node node){
        Queue<Node> mainQueue = new ArrayDeque<>();
        mainQueue.add(node);

        while(mainQueue.size() > 0){
            int cicl = mainQueue.size();

            for(int i=0; i< cicl; i++){
                node = mainQueue.remove();
                System.out.print(node.data+ " ");
                
                for(Node child : node.children){
                    mainQueue.add(child);
                }
            }
            System.out.println();
        }
    }

    private static class Pair{
        Node node;
        int level;

        Pair(){

        }

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    
    public static void levelOrderLinewise4(Node node){
        Queue<Pair> mainQueue = new ArrayDeque<>();
        mainQueue.add(new Pair(node, 1));
        int currentLevel = 1;
        while(mainQueue.size() > 0){

            Pair pair = mainQueue.remove();
            if( pair.level > currentLevel){
                currentLevel = pair.level;
                System.out.println();
            }
            System.out.print(pair.node.data + " ");
                
            for(Node child : pair.node.children){
                mainQueue.add(new Pair(child,pair.level+1));
            }
            
        }
    }
}
