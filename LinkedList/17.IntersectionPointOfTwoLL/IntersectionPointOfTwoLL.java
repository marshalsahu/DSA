public class IntersectionPointOfTwoLL {
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

        public static int intersectionPoint(LinkedListProgram l1, LinkedListProgram l2){
            Node t1 = l1.head;
            Node t2 = l2.head;

            int delta = Math.abs(l1.size - l2.size);
            
            if( l1.size > l2.size){
                for(int i=0; i < delta ; i++){
                    t1 = t1.next;
                }
            }else if (l1.size < l2.size){
                for(int i=0; i < delta ; i++){
                    t2 = t2.next;
                }
            }

            while(t1 != t2){
                t1 = t1.next;
                t2 = t2.next;
            }
            return t1.data;
        }

        
    }
    public static void main(String[] args) {
        LinkedListProgram llist = new LinkedListProgram();
        llist.addFirst(3);
        llist.addFirst(6);
        llist.addFirst(0);
        LinkedListProgram llist2 = new LinkedListProgram();
        llist2.addFirst(2);
        llist2.addFirst(8);
        llist2.addFirst(5);
        llist.display();
        llist2.display();
        LinkedListProgram res = LinkedListProgram.addTwoLinkedList(llist, llist2);
        res.display();

    }
}
