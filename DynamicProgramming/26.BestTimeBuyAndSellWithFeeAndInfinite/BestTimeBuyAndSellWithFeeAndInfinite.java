import java.util.Scanner;

public class BestTimeBuyAndSellWithFeeAndInfinite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prices = new int[n];
        for(int i=0; i<prices.length; i++){
            prices[i] = sc.nextInt();
        }

        int transactionFee = sc.nextInt();

        int buyStateProfit = -prices[0];
        int sellStateProfit = 0;

        for(int i=1; i<prices.length; i++){
            int newBuyStateProfit = 0;
            int newSellStateProfit = 0;

            if(sellStateProfit - prices[i] > buyStateProfit){
                newBuyStateProfit = sellStateProfit - prices[i];
            }else{
                newBuyStateProfit = buyStateProfit;
            }

            if(buyStateProfit + prices[i] - transactionFee > sellStateProfit){
                newSellStateProfit = buyStateProfit + prices[i] - transactionFee;
            }else{
                newSellStateProfit = sellStateProfit;
            }

            buyStateProfit = newBuyStateProfit;
            sellStateProfit = newSellStateProfit;
        }
        System.out.println(sellStateProfit);
    }
}
