import java.util.*;
public class CryptArithmetic {

    public static int getInt(String s1, HashMap<Character,Integer> hmap){
        String s = "";

        for(int i = 0; i < s1.length(); i++){
            s += hmap.get(s1.charAt(i));
        }

        return Integer.parseInt(s);
    }

    public static void solution(HashMap<Character, Integer> hmap, String unique, int idx, boolean[] useNumber, String s1, String s2, String s3){

        if( idx == unique.length()){
            
            int num1 = getInt(s1, hmap);
            int num2 = getInt(s2, hmap);
            int num3 = getInt(s3, hmap);

            if( num1 + num2 == num3){
                System.out.println("one solution found");
                for(int i = 0; i < 26; i++){
                    char ch = (char)('a' + i);
                    if(hmap.containsKey(ch)){
                        System.out.print(ch+" -> "+hmap.get(ch)+"   ");
                    }
                }
                System.out.println();
            }
            
            
            return;
        }

        char ch = unique.charAt(idx);
        for(int num = 0; num <= 9; num++){
            if( useNumber[num] == false){
                hmap.put(ch, num);
                useNumber[num] = true;
                solution(hmap, unique, idx+1, useNumber, s1, s2, s3);
                useNumber[num] = false;
                hmap.put(ch, -1); 
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        String unique = "";
        HashMap<Character, Integer> hmap = new HashMap<>();

        for(int i=0; i < s1.length(); i++){

            if(hmap.containsKey(s1.charAt(i)) == false){
                hmap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }

        for(int i=0; i < s2.length(); i++){

            if(hmap.containsKey(s2.charAt(i)) == false){
                hmap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }

        for(int i=0; i < s3.length(); i++){

            if(hmap.containsKey(s3.charAt(i)) == false){
                hmap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }

        boolean[] useNumber = new boolean[10];
        System.out.println("unique string is "+ unique);
        solution(hmap, unique, 0, useNumber, s1, s2, s3);
    }
}
