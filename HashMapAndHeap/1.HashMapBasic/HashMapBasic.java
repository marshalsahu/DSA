import java.util.HashMap;
import java.util.*;

public class HashMapBasic{

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Germany", 90);
        hm.put("china", 30);
        hm.put("uk", 50);

        System.out.println(hm);
        hm.put("India", 110);
        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("utopia"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("utopia"));

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        //keyset is used to loop through hashmap

        for(String s : hm.keySet()){
            Integer val = hm.get(s);
            System.out.println(s+"-> "+val);
        }
    }
}