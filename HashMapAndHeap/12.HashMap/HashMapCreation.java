import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCreation {
    
    public static class HashMap<K,V>{
       
        private class HMNode{
            K key;
            V value;

            public HMNode(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<HMNode>[] buckets;
        private int size;

        public HashMap(){
            initBuckets(4);
            size=0;
        }

        private void initBuckets(int bucketSize){
            buckets = new LinkedList[bucketSize];
            for(int i=0; i<bucketSize; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = getIndexWithinBucket(bi, key);

            if( di != -1){
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }else{
                HMNode node = new HMNode(key,value);
                buckets[bi].add(node);
                size++; 
            }

            double lambda = size / buckets.length;
            if( lambda > 2.0){
                rehash();
            }
        }

        private void rehash(){
            LinkedList<HMNode>[] oldBucket = buckets;
            initBuckets(buckets.length *2);

            for(int i=0; i<oldBucket.length; i++){
                for(HMNode node : oldBucket[i]){
                    put(node.key, node.value);
                }
            }
            
        }

        private int hashFunction(K key){
            int hashvalue = key.hashCode();
            return Math.abs(hashvalue)%buckets.length;
        }

        private int getIndexWithinBucket(int bucketIndex, K key){
            int di = 0;
            for(HMNode node : buckets[bucketIndex]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = getIndexWithinBucket(bi, key);

            if( di != -1){
                return true;
            }else{
                return false;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = getIndexWithinBucket(bi, key);

            if( di != -1){
                HMNode node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = getIndexWithinBucket(bi, key);

            if( di != -1){
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length ; i++){
                for(HMNode node : buckets[i]){
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public int size(){
            return size;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> hmap = new HashMap();
        hmap.put("India", 10);
        hmap.put("Australia", 20);
        hmap.put("winki", 40);
        System.out.println("value of india is "+ hmap.get("India"));
        System.out.println("india exist "+hmap.containsKey("India"));
        System.out.println("utopia exist "+hmap.containsKey("utopia"));
        System.out.println("removing india"+hmap.remove("India"));
        System.out.println("india exist "+hmap.containsKey("India"));
        System.out.println("utopia exist "+hmap.containsKey("utopia"));

    }
}
