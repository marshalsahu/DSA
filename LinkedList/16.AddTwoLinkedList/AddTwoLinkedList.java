public class AddTwoLinkedList {
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

        public static int addTwolinkedListHelper(Node llist1, int pv1, Node llist2, int pv2, LinkedListProgram res){
            if(llist1 == null && llist2 == null){
                return 0;
            }

            if( pv1 > pv2){
                int oldCarry = addTwolinkedListHelper(llist1.next, pv1-1, llist2, pv2, res);
                int sum = llist1.data + oldCarry;
                int newData = sum %10;
                int newCarry = sum / 10;
                res.addFirst(newData);
                return newCarry;
            }else if( pv1 < pv2){
                int oldCarry = addTwolinkedListHelper(llist1, pv1, llist2.next, pv2-1, res);
                int sum = llist2.data + oldCarry;
                int newData = sum %10;
                int newCarry = sum / 10;
                res.addFirst(newData);
                return newCarry;
            }else{
                int oc = addTwolinkedListHelper(llist1.next, pv1-1, llist2.next, pv2-1, res);

                int sum = llist1.data + llist2.data + oc;
                int newData = sum %10;
                int newCarry = sum / 10;
                res.addFirst(newData);
                return newCarry;
            }
        }

        public static LinkedListProgram addTwoLinkedList(LinkedListProgram llist1, LinkedListProgram llist2){
            LinkedListProgram res = new LinkedListProgram();

            int oldCarry = addTwolinkedListHelper(llist1.head, llist1.size, llist2.head, llist2.size, res);

            if( oldCarry > 0){
                res.addFirst(oldCarry);
            }
            return res;
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
