import java.util.*;

public class Mindeveloper {
    static ArrayList<Integer> res = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//total skills
        HashMap<String, Integer> hMap = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            hMap.put(sc.next(), i);
        }
        int tp = sc.nextInt();
        int[] persons = new int[tp];
        for(int i=0; i< tp; i++){
            int skills = sc.nextInt();
            for(int j=0; j<skills; j++){
                String skill = sc.next();
                int index = hMap.get(skill);
                persons[i] = persons[i] | (1 << index);
            }
        }
        solution(persons,n,0,new ArrayList<Integer>(), 0);
        System.out.println(res);
        sc.close();
    }

    public static void solution( int[] persons, int skills, int cp, ArrayList<Integer> ans, int mask){

        if(cp == persons.length){
            if( mask == (1 << skills)-1){
                if( res.size() == 0 || ans.size() < res.size() ){
                    res = new ArrayList<>(ans);
                }
            }
            return;
        }

        solution(persons,skills, cp+1, ans, mask );
        ans.add(cp);
        solution(persons, skills, cp+1, ans, mask | (persons[cp]));
        ans.remove( ans.size()-1);
        
    }
}
