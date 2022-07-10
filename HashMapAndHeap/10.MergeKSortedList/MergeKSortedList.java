import java.util.*;

public class MergeKSortedList {
    
    public static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int value;

        public Pair(int li, int di, int value){
            this.li = li;
            this.di = di;
            this.value = value;
        }

        public int compareTo(Pair o){
            return this.value - o.value;
        }
    }

    public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<lists.size(); i++){
            Pair p = new Pair(i,0,lists.get(i).get(0));
            pq.add(p);
        }

        while(pq.size() > 0){
            Pair p = pq.remove();
            res.add(p.value);
            p.di++;

            if( p.di < lists.get(p.li).size()){
                p.value = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(10, 20, 30, 40 , 50 , 60 , 70));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(5, 7, 9, 11, 13, 15, 17, 19));
        ArrayList<Integer> l3 = new ArrayList<>(Arrays.asList(12,24,36,42,50));

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        ArrayList<Integer> res = mergeKSortedList(lists);
        for(int val: res){
            System.out.print(val+" ");
        }
    }
}
