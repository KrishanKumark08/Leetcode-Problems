class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] arr = new int[prices.length][2][k+1];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int l=0;l<k+1;l++)
                    arr[i][j][l]=-1;
            }
        }
       return bestBuy(prices,0, 1, k, arr);
    }
    public int bestBuy(int[] prices, int currentDay, int canBuy, int transCount, int[][][] memo){
        
        if(currentDay==prices.length-1 && canBuy==1)
            return 0;
        
        if(currentDay >= prices.length || transCount<=0)
            return 0;
    
        // String currentKey = Integer.toString(currentDay) + "" + Integer.toString(canBuy) + "" + Integer.toString(transCount);
        // We Can't Use this Approach as it is giving TLE
        
        //String currentKey = currentDay + "_" + canBuy + "_" + transCount;
        
        if(memo[currentDay][canBuy][transCount]!=-1)
                return memo[currentDay][canBuy][transCount];
        
        if(canBuy==1){
            int idle = bestBuy(prices, currentDay + 1, canBuy, transCount, memo);
            int buy = bestBuy(prices, currentDay + 1, 0, transCount, memo) - prices[currentDay];
            
            memo[currentDay][canBuy][transCount] = Math.max(idle,buy);
            return memo[currentDay][canBuy][transCount];
        }
        else
        {
            int idle = bestBuy(prices, currentDay + 1, canBuy, transCount, memo);
            int sell = bestBuy(prices, currentDay + 1, 1, transCount - 1, memo) + prices[currentDay];
            
            memo[currentDay][canBuy][transCount] = Math.max(idle,sell);
            return memo[currentDay][canBuy][transCount];
        }
            
    }
}