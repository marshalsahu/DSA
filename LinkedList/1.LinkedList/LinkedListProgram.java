public class LinkedListProgram {

    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        public static Node head;
        public static Node tail;
        int size;

        public void addLast(int val){

            Node node = new Node();
            node.data = val;
            node.next = null;
            if(size == 0){
                head = tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public int size(){
            return size;
        }

        public void display(){
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data+ " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void removeFirst(){
            if(size == 0){
                System.out.println("No element in List");
            }else if(size == 1){
                head = tail = null;
                size = 0;
            }else{
                head = head.next;
                size --;
            }
 
        }

        public int getFirst(){

            if(size == 0){
                System.out.println("Size is empty");
                return -1;
            }else{
                return head.data;
            }
            
        }

        public int getLast(){

            if(size == 0){
                System.out.println("size is empty");
                return -1;
            }else{
                return tail.data;
            }
            
        }

        public int getAt(int idx){
            if(size == 0){
                System.out.println("size is empty");
                return -1;
            }else if(idx < 0 || idx >= size){
                System.out.println("invalid arguments");
                return -1;
            }else{
                Node temp = head;
                for(int i=0; i<idx; i++){
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        public void addFirst(int val){
            Node node = new Node();
            node.data = val;
            node.next = head;
            head = node;

            if(size == 0){
                tail = node;
            }
            size++;
        }

        public void addAt(int val, int idx){
            
            if(idx < 0 || idx > size){
                System.out.println("index is not valid");
            }else if(idx == 0){
                addFirst(val);

            }else if(idx == size){
                addLast(val);
            }else{
                Node node = new Node();
                node.data = val;
                
                Node temp = head;
                for(int i=0; i<idx-1; i++){
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
            }
            size++;
        }
   
        public void removeLast(){

            if(size == 0){
                System.out.println("not possible");
            }else if(size == 1){
                head = tail = null;
                size--;
            }else{
                Node temp = head;
                while(temp.next != tail){
                    temp = temp.next;
                }
                tail = temp;
                temp.next = null;
                size--;
            }
        }
        
        private Node getNodeAt(int idx){
            
            Node temp = head;
            for(int i=0; i<idx; i++){
                temp = temp.next;
            }
            return temp;
        
        }
        //data iterative
        public void reverseData(){
            int li = 0;
            int ri = size-1;
            while( li < ri){
                Node leftNode = getNodeAt(li);
                Node rightNode = getNodeAt(ri);

                int temp = leftNode.data;
                leftNode.data = rightNode.data;
                rightNode.data = temp;

                li++;
                ri--;
            }
        }

        //pointeriterative
        public void reversePI(){
            Node prev = null;
            Node curr = head;
         
            while(curr != null){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node temp = head;
            head = tail;
            tail = temp;
        
        }
    
        public void removeAt(int idx){
            if( idx < 0 || idx >= size ){
                System.out.println("Invalid arguments");
            }else if(idx == 0){
                removeFirst();
            }else if(idx == size-1){
                removeLast();
            }else{
                Node temp = head;
                for(int i=0; i<idx-1 ; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        LinkedList li = new LinkedList();
        li.addLast(10);
        li.addLast(20);
        li.addLast(30);
        li.addLast(40);
        li.display();
        li.reversePI();
        li.display();
        li.removeAt(2);
        li.display();
    }
}