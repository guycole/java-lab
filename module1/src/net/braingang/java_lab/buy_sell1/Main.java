package net.braingang.java_lab.buy_sell1;

public class Main {

    public int maxProfit(int[] prices) {
        int profit = 0;

        int buyNdx = -1;
        int sellNdx = -1;

        for (int ii = 0; ii < prices.length-1; ii++) {
            int temp = prices[ii+1] - prices[ii];
            if ((prices[ii+1] - prices[ii]) > 0) {
                if (buyNdx < 0) {
                    buyNdx = ii;
                    //System.out.println("buy:" + ii);
                } else {
                    //System.out.println("skipping buy:" + ii);
                }
            } else {
                if (buyNdx < 0) {
                    //System.out.println("skipping sell:" + ii);
                } else {
                   // System.out.println("sell:" + ii);
                    sellNdx = ii;
                    profit += prices[sellNdx] - prices[buyNdx];
                    buyNdx = -1;
                }
            }
        }

        if (buyNdx > sellNdx) {
            sellNdx = prices.length-1;
            profit += prices[sellNdx] - prices[buyNdx];
        }

        if (sellNdx < 0) {
            sellNdx = prices.length-1;

            if (buyNdx >= 0) {
                profit += prices[sellNdx] - prices[buyNdx];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(main.maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(main.maxProfit(prices2));

        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println(main.maxProfit(prices3));

        int[] prices4 = {6, 1, 3, 2, 4, 7};
        System.out.println(main.maxProfit(prices4));

        System.out.println("end");
    }
}
