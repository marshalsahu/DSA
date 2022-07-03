public class MergeTwoSortedLinkedList {
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
        
    
       
        public static LinkedListProgram mergeTwoSortedLinkedList(LinkedListProgram l1, LinkedListProgram l2){
            Node one = l1.head;
            Node two = l2.head;
            LinkedListProgram result = new LinkedListProgram();

            while(one != null && two != null){
                if(one.data > two.data){
                    result.addLast(two.data);
                    two = two.next;
                }else{
                    result.addLast(one.data);
                    one = one.next;
                }
            }

            while(one != null){
                result.addLast(one.data);
                one = one.next;
            }

            while(two != null){
                result.addLast(two.data);
                two = two.next;
            }

            return result;
        }

        
    }
    public static void main(String[] args) {
        LinkedListProgram llist = new LinkedListProgram();
        llist.addFirst(30);
        llist.addLast(40);
        llist.addFirst(20);
        llist.addFirst(10);
       LinkedListProgram llist2 = new LinkedListProgram();
       llist2.addFirst(13);
       llist2.addLast(15);
       llist2.addLast(25);
       llist2.addLast(45);

       LinkedListProgram llist3 = LinkedListProgram.mergeTwoSortedLinkedList(llist,llist2);
       llist3.display();

    }
}
