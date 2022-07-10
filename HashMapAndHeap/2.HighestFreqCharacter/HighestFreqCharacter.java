import java.util.HashMap;
import java.util.Scanner;

public class HighestFreqCharacter {
    public static void main(String[] args) {
        HashMap<Character, Integer> hm = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for(int i=0; i<str.length(); i++){
            Character ch = str.charAt(i);

            if(hm.containsKey(ch)){
                int val = hm.get(ch);
                hm.put(ch, val+1);
            }else{
                hm.put(ch, 1);
            }
        }
        int maxfreq = hm.get(str.charAt(0));
        Character maxFreqChar = str.charAt(0);
        for(Character ch : hm.keySet()){
            if(hm.get(ch) > maxfreq){
                maxfreq = hm.get(ch);
                maxFreqChar = ch;
            }
        }

        System.out.println(maxFreqChar +" -> "+maxfreq);


    }
}
