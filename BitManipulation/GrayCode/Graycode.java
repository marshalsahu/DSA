package GrayCode;
import java.util.*;
import java.io.*;

//Gray code using recursion and backtracking

public class Graycode {
    public static ArrayList<String> solution(int n){

        if(n==1){
            ArrayList<String> mList = new ArrayList<>();
            mList.add("0");
            mList.add("1");
            return mList;
        }

        ArrayList<String> res = solution(n-1);
        ArrayList<String> mres = new ArrayList<>();
        for(int i=0 ; i < res.size(); i++){
            String temp = res.get(i);
            mres.add("0"+temp);
        }
        for(int i=res.size()-1; i >= 0 ; i--){
            String temp = res.get(i);
            mres.add("1"+temp);
        }

        return mres;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<String> result = solution(n);
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
