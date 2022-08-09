import java.util.*;

public class CrosswordPuzzle{

    public static void solution(char[][] arr, String[] words, int idx){

        if(idx == words.length){
            print(arr);
            return;
        }

        String word = words[idx];
        System.out.println("WORKING ON WORD "+ word);
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)){
                    if(canPlaceWordHorizontally(arr,word,i,j)){
                        boolean[] weplaced = placeWordHorizontally(arr,word,i,j);
                        solution(arr, words, idx+1);
                        unplaceWordHorizontally(arr,weplaced,i,j);
                    }

                    if(canPlaceWordVertically(arr,word,i,j)){
                        boolean[] weplaced = placeWordVertically(arr, word, i, j);
                        solution(arr, words, idx+1);
                        unplaceWordVertically(arr, weplaced, i, j);
                    }
                }
            }
        }
    }

    public static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j){
        boolean[] wePlace = new boolean[word.length()];
        for(int jj=0; jj < word.length(); jj++){
            if(arr[i][j+jj] == '-'){
                arr[i][j + jj] = word.charAt(jj);
                wePlace[jj] = true;
            }
        }
        return wePlace;
    }

    public static void unplaceWordHorizontally(char[][] arr, boolean[] weplaced, int i, int j){
        for(int jj=0; jj<weplaced.length; jj++){
            if(weplaced[jj] == true){
                arr[i][j + jj] = '-';
            }
        }
    }

    public static boolean[] placeWordVertically(char[][] arr, String word, int i, int j){
        boolean[] wePlace = new boolean[word.length()];
        for(int ii=0; ii < word.length(); ii++){
            if(arr[i + ii][j] == '-'){
                arr[i + ii][j] = word.charAt(ii);
                wePlace[ii] = true;
            }
        }
        return wePlace;
    }

    public static void unplaceWordVertically(char[][] arr, boolean[] weplaced, int i, int j){
        for(int ii=0; ii < weplaced.length; ii++){
            if(weplaced[ii] == true){
                arr[i + ii][j] = '-';
            }
        }
    }
    

    public static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j){
        //left side
        if( j-1 >= 0 && arr[i][j-1] != '+'){
            return false;
        }else if(j + word.length() < arr[0].length && arr[i][j+word.length()] != '+'){
            return false;
        }

        for(int jj=0; jj < word.length(); jj++){
            if(j + jj > arr[0].length){
                return false;
            }
            if(arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)){
                continue;
            }else{
                return false;
            }
        }

        return true;
    }

    public static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j){
        if(i-1 >= 0 && arr[i-1][j] != '+'){
            return false;
        }else if( i+word.length() < arr.length && arr[i+word.length()][j] != '+'){
            return false;
        }

        for(int ii=0; ii <word.length(); ii++){
            if(i + ii > arr.length){
                return false;
            }
            if(arr[i+ii][j] == '-' || arr[i+ii][j] == word.charAt(ii)){
                continue;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void print(char[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for(int i=0; i<10; i++){
            String str = sc.next();
            arr[i] = str.toCharArray();
        }
        System.out.println("Enter words count");
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i=0; i<n; i++){
            words[i] = sc.next();
        }
        
        solution(arr,words,0);
    }
}