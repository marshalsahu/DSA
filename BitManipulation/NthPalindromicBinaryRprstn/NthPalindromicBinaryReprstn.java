package NthPalindromicBinaryRprstn;

import java.util.Scanner;
//nth palindromic binary representation
public class NthPalindromicBinaryReprstn {
    public static int getRev(int n){
        int ans = 0;
        while(n != 0){
            int lb= n&1;
            ans |= lb;
            ans <<= 1;
            n >>= 1;
        }
        ans >>= 1;
        return ans;
    }

    public static void solution(int n){
        int length=1;
        int count=1;

        while(count < n){
            length++;
            count += ( 1 << (length-1)/2);  //{1,1}, {2, (11)}, {3, {101,111}}, {4, {1001,1111}}, {5, {10001, 10101, 11011,1111}}
        }
        count -= ( 1 << (length-1)/2);
        int offset = n-count-1;

        int ans = 1 << (length-1);
        offset <<= length/2;
        ans = ans | offset;
        int valFR = ans >> length/2;
        int rev = getRev(valFR);
        ans = ans | rev;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
        sc.close();
    }
    
}
