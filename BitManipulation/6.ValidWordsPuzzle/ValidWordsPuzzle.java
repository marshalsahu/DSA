
//to tell count of valid words in puzzle
import java.util.*;


public class ValidWordsPuzzle {
    public static ArrayList<Integer> findNumberOfValidWords(String[] words, String[] puzzles){
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Character,ArrayList<Integer>> hMap = new HashMap<>();
        for(int i=0; i<26; i++){
            hMap.put((char)('a'+i), new ArrayList<Integer>());
        }
        for(String word : words){
            int mask =0;
            for(char ch : word.toCharArray()){
                int bit = ch - 'a';
                mask = (mask | (1 << bit));
            }
            HashSet<Character> uniqueCharacters = new HashSet<>();

            for( char ch : word.toCharArray()){
                if(uniqueCharacters.contains(ch)){
                    continue;
                }
                uniqueCharacters.add(ch);
                hMap.get(ch).add(mask);
            }
        }

        for(String puzzle : puzzles){
            int mask = 0;
            for(char ch : puzzle.toCharArray()){
                int bit = ch - 'a';
                mask = ( mask | (1 << bit));
            }
            int count = 0;
            char fch = puzzle.charAt(0);
            ArrayList<Integer> wList = hMap.get(fch);
            for(Integer i : wList){
                if( (mask & i) == i){
                    count+=1;
                }
            }
            result.add(count);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i=0 ;i< n; i++){
            words[i] = sc.next();
        }
        int m = sc.nextInt();
        String[] puzzles = new String[m];
        for(int i=0 ; i< m ; i++){
            puzzles[i] = sc.next();
        }

        ArrayList<Integer> result = findNumberOfValidWords(words, puzzles);
        for (int val: result){
            System.out.print(val+" ");
        }

        sc.close();
    }
}
