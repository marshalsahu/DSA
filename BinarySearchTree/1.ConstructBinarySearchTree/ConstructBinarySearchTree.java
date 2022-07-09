import java.util.*;

public class ConstructBinarySearchTree{
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

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12,25,37,50,62,70,87};
        Node root = construct(arr, 0, arr.length -1);
        display(root);
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
}