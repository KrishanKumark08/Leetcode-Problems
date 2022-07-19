class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int[][] dp = new int[prices.length + 1][2];
        for(int i = prices.length - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                if(j==1){
                    
                    int buy = dp[i + 1][0] - prices[i];
                    int idle = dp[i + 1][1];
                    
                    dp[i][j] = Math.max(buy, idle);
                }
                else
                {
                    
                    int sell = dp[i + 1][1] + prices[i] - fee;
                    int idle = dp[i + 1][0];  
                    
                    dp[i][j] = Math.max(sell, idle);                
                }
            }
        }
        
        return dp[0][1];
        
      //return bestBuy(prices,0, 1, fee, new HashMap<String,Integer>());
    }
//     public int bestBuy(int[] prices, int currentDay, int canBuy, int fee, HashMap<String,Integer> memo){
        
//         if(currentDay >= prices.length )
//             return 0;
    
//          String currentKey = Integer.toString(currentDay) + "_" + Integer.toString(canBuy);
//         // We Can't Use this Approach as it is giving TLE
        
//         //String currentKey = currentDay + "_" + canBuy ;
        
//         if(memo.containsKey(currentKey))
//                 return memo.get(currentKey);
        
//         if(canBuy==1){
//             int idle = bestBuy(prices, currentDay + 1, canBuy, fee, memo);
//             int buy = bestBuy(prices, currentDay + 1, 0, fee, memo) - prices[currentDay];
            
//             memo.put(currentKey,Math.max(idle,buy));
//             return memo.get(currentKey);
//         }
//         else
//         {
//             int idle = bestBuy(prices, currentDay + 1, canBuy, fee, memo);
//             int sell = bestBuy(prices, currentDay + 1, 1, fee, memo) + prices[currentDay] - fee;
            
//             memo.put(currentKey,Math.max(idle,sell));
//             return memo.get(currentKey);
//         }
            
//     }
}