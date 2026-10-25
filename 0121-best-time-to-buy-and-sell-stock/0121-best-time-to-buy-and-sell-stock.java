class Solution {
    public int maxProfit(int[] prices) {
        int MinBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i<prices.length; i++){
            int Buy = prices[i];
            if(Buy < MinBuy){
                MinBuy = Buy;
            }
            else{
                int Profit = Buy- MinBuy;
                maxProfit = Math.max(maxProfit, Profit);
            }
        }
        return maxProfit;
    }
}