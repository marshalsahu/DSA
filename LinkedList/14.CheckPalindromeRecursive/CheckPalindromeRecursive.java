public class CheckPalindromeRecursive {
    public static class Node{
        int data;
        Node next;
    }


    public static class LinkedListProgram{
        Node head;
        Node tail;
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
        
    
       
        private boolean isPalindromeHelper(Node head, int floor){
            if(head == null){
                return true;
            }
            boolean prev = isPalindromeHelper(head.next, floor+1);

            if(floor >= size/2){
                if( prev == false || head.data != recursiveLeft.data){
                    return false;
                }
                recursiveLeft = recursiveLeft.next;
            }
            if (!prev){
                return prev;
            }
            return true;
            // 2nd way
            // boolean rres = isPalindromeHelper(head);
            // if(rres == false){
            //     return false;
            // }else if( head.data != recursiveLeft.data){
            //     return false;
            // }else{
            //     recursiveLeft = recursiveLeft.next;
            //     return true;
            // }
        }
        Node recursiveLeft;
        public void isPalindrome(){
            recursiveLeft = head;
            if( isPalindromeHelper(head,0)){
                System.out.println("is palindrome");
            }else{
                System.out.println("is not palindrome");
            }
        }

        
    }
    public static void main(String[] args) {
        LinkedListProgram llist = new LinkedListProgram();
        llist.addFirst(30);
        llist.addFirst(65);
        llist.addFirst(31);
        llist.addFirst(42);
        llist.addFirst(97);
        llist.addFirst(11);
        llist.display();
        llist.isPalindrome();
       
    }
}
