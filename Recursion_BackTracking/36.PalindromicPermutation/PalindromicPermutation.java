import java.util.*;

public class PalindromicPermutation {

    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf){

        if( cs > ts){
            String rev = "";
            for(int i=asf.length() -1; i>=0; i--){
                rev+=asf.charAt(i);
            }
            if( oddc != null){
                asf += oddc;
            }
            asf  += rev;
            System.out.println(asf);
            return;
        }

        for(char ch : fmap.keySet()){
            int freq = fmap.get(ch);
            if( freq > 0){
                fmap.put(ch, freq-1);
                generatepw(cs+1, ts, fmap, oddc, asf+ch);
                fmap.put(ch, freq);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashMap<Character,Integer> fmap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(fmap.containsKey(ch)){
                int ov = fmap.get(ch);
                fmap.put(ch, ov+1);
            }else{
                fmap.put(ch, 1);
            }
        }

        Character oddc = null;
        int odds = 0;
        int length = 0;

        for(char ch : fmap.keySet()){
            int freq = fmap.get(ch);

            if(freq % 2 == 1){
                oddc = ch;
                odds+=1;
            }

            fmap.put(ch, freq/2);
            length += freq/2;
        }

        if(odds > 1){
            System.out.println("not possible");
        }else{
            generatepw(1,length, fmap, oddc,"");
        }
    }
}
