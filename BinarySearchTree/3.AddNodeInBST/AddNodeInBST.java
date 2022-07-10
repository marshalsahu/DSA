import javax.xml.crypto.Data;

public class AddNodeInBST {
    public static class Node{
        int data;
        Node right;
        Node left;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12,25,37,50,62,70,87};
        Node root =construct(arr, 0, arr.length -1);
        display(root);
        System.out.println(size(root));
        System.out.println(height(root));
        System.out.println(max(root));
        System.out.println(min(root));
         root = addNode(root, 100);
        display(root);
        root = addNode(root, 49);
        display(root);
        System.out.println(find(root, 87));
    }


    public static void display(Node node){

        if(node == null){
            return;
        }
        String s = "";
        s += node.left == null ? "-" : node.left.data + "";
        s += " -> "+node.data+" -> ";
        s += node.right == null ? "-" : node.right.data + "";

        System.out.println(s);
        display(node.left);
        display(node.right);
    }

    public static Node construct(int[] arr,int low, int high){
        
        if(low > high){
            return null;
        }
        
        int mid = (low+high)/2;
        int data = arr[mid];
        Node lh = construct(arr, low, mid-1);
        Node rh = construct(arr, mid+1, high);
        Node newNode = new Node(data, lh, rh);
        return newNode;
    }

    public static int max(Node node){
        if(node.right != null){
            return max(node.right);
        }else{
            return node.data;
        }
    }

    public static int min(Node node){
        if(node.left != null){
            return min(node.left);
        }else{
            return node.data;
        }
    }

    public static int height(Node node){
        if(node == null){
            return -1;
        }
        int lh = height(node.left);
        int rh  = height(node.right);
        int ch = Math.max(lh, rh);
        return ch+1;
    }
    public static int size(Node node){

        if(node == null){
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }

    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }
        if(data < node.data){
            return find(node.left , data);
        }else if( data > node.data){
            return find(node.right, data);
        }else{
            return true;
        }
    }

    public static Node addNode(Node root, int data){
        if(root == null){
            Node nwNode = new Node(data, null, null);
            return nwNode;
        }
        if( data > root.data ){
            root.right = addNode(root.right, data);
        }else if(data < root.data){
            root.left = addNode(root.left, data);
        }else{
            //nothing to do
        }
        return root;
    }
}
