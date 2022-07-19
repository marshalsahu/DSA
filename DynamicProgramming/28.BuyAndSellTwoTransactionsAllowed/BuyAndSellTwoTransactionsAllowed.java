import java.util.*;
public class BuyAndSellTwoTransactionsAllowed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prices = new int[n];
        for(int i=0; i<prices.length; i++){
            prices[i] = sc.nextInt();
        }

        int maxProfitIfSoldToday = 0;
        int leastSoFar = prices[0];
        int[] dpmaxProfitIfSoldUptoToday = new int[prices.length];

        for(int i=1; i<prices.length; i++){
            if(prices[i] <= leastSoFar){
                leastSoFar = prices[i];
            }
            maxProfitIfSoldToday = prices[i] - leastSoFar;

            if( maxProfitIfSoldToday > dpmaxProfitIfSoldUptoToday[i-1]){
                dpmaxProfitIfSoldUptoToday[i] = maxProfitIfSoldToday;
            }else{
                dpmaxProfitIfSoldUptoToday[i] = dpmaxProfitIfSoldUptoToday[i-1];
            }
        }

        int maxProfitIfBuyToday = 0;
        int maxSoFar = prices[prices.length-1];
        int[] dpmaxProfitIfBoughtIncludingOrAfterToday = new int[prices.length];

        for(int i=prices.length-2; i>=0; i--){
            if (maxSoFar < prices[i]){
                maxSoFar = prices[i];
            }

            maxProfitIfBuyToday = maxSoFar - prices[i];

            if( maxProfitIfBuyToday > dpmaxProfitIfBoughtIncludingOrAfterToday[i+1]){
                dpmaxProfitIfBoughtIncludingOrAfterToday[i] = maxProfitIfBuyToday;
            }else{
                dpmaxProfitIfBoughtIncludingOrAfterToday[i] = dpmaxProfitIfBoughtIncludingOrAfterToday[i+1];
            }
        }

        int overallProfit = 0;
        for(int i=0; i<prices.length; i++){
            if( dpmaxProfitIfBoughtIncludingOrAfterToday[i] + dpmaxProfitIfSoldUptoToday[i] > overallProfit){
                overallProfit = dpmaxProfitIfBoughtIncludingOrAfterToday[i] + dpmaxProfitIfSoldUptoToday[i];
            }
        }

        System.out.println(overallProfit);
    }
}
