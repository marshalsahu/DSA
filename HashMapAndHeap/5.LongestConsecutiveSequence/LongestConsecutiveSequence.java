import java.util.*;;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int[] arr1 = new int[a1];

        for(int i=0; i<a1 ; i++){
            arr1[i] = sc.nextInt();
        }

        for(int val : arr1){
            hm.put(val, true);
        }

        for(int val : arr1){
            if(hm.containsKey(val-1)){
                hm.put(val, false); 
            }
        }
        int maxStartPoint = 0;
        int maxStartLength = 0;
        for(int val : arr1){
            if(hm.get(val) == true){
                int tempLength = 1;
                int tempStartPoint = val;

                while(hm.containsKey(tempStartPoint+tempLength)){
                    tempLength++;
                }

                if( maxStartLength < tempLength){
                    maxStartLength = tempLength;
                    maxStartPoint = tempStartPoint;
                }
            }

            
        }

        for(int i=0; i<maxStartLength; i++){
            System.out.print(maxStartPoint+i);
        }

    }
}
