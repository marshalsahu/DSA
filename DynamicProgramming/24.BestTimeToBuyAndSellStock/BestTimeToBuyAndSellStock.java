import java.util.*;
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prices = new int[n];
        for(int i=0; i<prices.length; i++){
            prices[i] = sc.nextInt();
        }

        int leastSoFar = Integer.MAX_VALUE;
        int overallProfit = 0;
        int profitIfSellToday = 0;

        for(int i=0; i<prices.length; i++){
            if(prices[i] <= leastSoFar){
                leastSoFar = prices[i];
            }
            profitIfSellToday = prices[i] - leastSoFar;

            if(profitIfSellToday > overallProfit){
                overallProfit = profitIfSellToday;
            }
        }

        System.out.println(overallProfit);
    }
}
