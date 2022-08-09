import java.util.Scanner;

public class MaximumScoreOfWordsProblem {

    public static int solution(String[] words, int[] freqArr, int[] score, int idx){

        if( idx == words.length){
            return 0;
        }
        int sno = 0 + solution(words, freqArr, score, idx+1);

        String word = words[idx];
        int wordScore = 0;
        boolean flag = true;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(freqArr[ch-'a'] == 0){
                flag = false;
            }

            freqArr[ch-'a']--;
            wordScore += score[ch-'a'];
        }
        int syes = 0;
        if(flag){
            syes = wordScore + solution(words, freqArr, score, idx+1);
        }

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            freqArr[ch-'a']++;
        }

        return Math.max(sno, syes);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfWords = sc.nextInt();
        String[] words = new String[noOfWords];
        for(int i=0; i<noOfWords; i++){
            words[i] = sc.next();
        }

        int noOfLetters = sc.nextInt();
        char[] letters = new char[noOfLetters];
        for(int i=0; i<noOfLetters; i++){
            letters[i] = sc.next().charAt(0);
        }
        
        int[] score = new int[26];
        for(int i=0; i<score.length; i++){
            score[i] = sc.nextInt();
        }

        if(words == null || words.length == 0 || letters == null
            || letters.length == 0 || score.length == 0){
                System.out.println(0);
                return;
        }

        int[] freqArr = new int[26];
        for(int i=0; i<letters.length; i++){
            char ch= letters[i];
            freqArr[ch-'a']++;
        }

        System.out.println(solution(words,freqArr, score, 0));

    }
}
