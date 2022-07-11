import java.util.ArrayList;
import java.util.Comparator;

public class ComparableComparator {

    public static class Student implements Comparable<Student>{
        int rollno;
        int height;
        int weight;

        Student(int rollno,int height, int weight){
            this.rollno = rollno;
            this.height = height;
            this.weight = weight;
        }

        public int compareTo(Student o){
            return this.rollno - o.rollno;
        }

        public String toString(){
            return this.rollno+"->"+this.height+"->"+this.weight;
        }
    }

    public static class StudentWtComparator implements Comparator<Student>{

        public int compare(Student s, Student o){
            return s.weight - o.weight;
        }
    }
     
    public static class PriorityQueue<T>{
        ArrayList<T> list = new ArrayList<>();
        Comparator comp;

        public PriorityQueue(){
            list = new ArrayList<>();
            comp = null;
        }

        public PriorityQueue(Comparator c){
            list = new ArrayList<>();
            this.comp = c;
        }

        public int size(){
            return list.size();
        }

        public T peek(){
            if(list.size() == 0){
                System.out.println("underflow");
                return null;
            }
            return list.get(0);
        }
        private boolean isSmaller(int i, int j){
            if(comp == null){
                Comparable ith = (Comparable)list.get(i);
                Comparable jth = (Comparable)list.get(j);

                if(ith.compareTo(jth) < 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                T ith = list.get(i);
                T jth = list.get(j);
                if(comp.compare(ith, jth) < 0){
                    return true;
                }else{
                    return false;
                }
                
            }
        }

        public void add(T val){
            list.add(val);

            upheapfiy(list.size()-1);
        }

        private void upheapfiy(int index){
            if(index == 0){
                return;
            }

            int pi = (index-1)/2;
            if (isSmaller(index, pi)){
                swap(index,pi);
                upheapfiy(pi);
            }
        }

        private void swap(int i, int j){
            T ith = list.get(i);
            T jth = list.get(j);
            list.set(i, jth);
            list.set(j, ith);
        }

        public T remove(){
            if(list.size() == 0){
                System.out.println("underflow");
                return null;
            }
            swap(0, list.size()-1);
            T data = list.remove(list.size()-1);
            downheapify(0);
            return data;
        }

        private void downheapify(int pi){
            int mini = pi;
            int leftChildi = 2 * pi + 1;
            if( leftChildi < list.size() && isSmaller(leftChildi, pi)){
                mini = leftChildi;
            }

            int rightChildi = 2 * pi + 2;
            if( rightChildi < list.size() && isSmaller(rightChildi, pi)){
                mini = rightChildi;
            }

            if( pi != mini){
                swap(pi,mini);
                downheapify(mini);
            }

        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue(new StudentWtComparator());
        pq.add(new Student(10, 172, 80));
        pq.add(new Student(20, 165, 81));
        pq.add(new Student(5, 189, 63));
        pq.add(new Student(17, 165, 83));
        pq.add(new Student(32, 177, 82));
        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.println(pq.remove());


        System.out.println(pq.size());
        
        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }
}
