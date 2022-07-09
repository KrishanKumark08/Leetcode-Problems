class Solution {
    public int maxProfit(int[] prices) {
        return maximumProfit(prices, 0, true, new HashMap<>());
    }
    
    private int maximumProfit(int[] prices, int currentDay , boolean canBuy, HashMap<String, Integer> memo){
        if(currentDay >= prices.length){
            return -100000;
        }
        
        
        String currentKey = currentDay + "_" + canBuy;
        
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int idle = 0;
        int buy = 0;
        int sell = 0;
        
        idle = maximumProfit(prices, currentDay + 1, canBuy, memo);
        
        if(canBuy){
            buy = -prices[currentDay] + maximumProfit(prices, currentDay + 1, false, memo);
        }
        else{
            sell = prices[currentDay];
        }
        
        memo.put(currentKey, Math.max(idle, Math.max(buy, sell)));
        return memo.get(currentKey);
        
    }
    
}