import java.util.*;
public class BestTimeBuyAndSellWithCooldown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prices = new int[n];
        for(int i=0; i<prices.length; i++){
            prices[i] = sc.nextInt();
        }
        //cooldown of 1 day
        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;

        for(int i=1; i<prices.length; i++){
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;

            if( ocsp - prices[i] > obsp){
                nbsp = ocsp - prices[i];
            }else{
                nbsp = obsp;
            }

            if ( prices[i] + obsp > ossp){
                nssp = prices[i] + obsp;
            }else{
                nssp = ossp;
            }

            if ( ossp > ocsp){
                ncsp = ossp;
            }else{
                ncsp = ocsp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        System.out.println(ossp);
    }
}
