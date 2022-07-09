class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = countcoins(coins , 0 , amount , new HashMap<>());
        
        if(ans >= 100000)
            return -1;
        
        return ans;
    }
    
    public int countcoins(int[] coins , int current , int target , HashMap<String ,Integer> memo){
        
        if(target == 0)
            return 0;
        if(current >= coins.length)
            return 100000;
        
        String key = current + "_" + target;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int consider = 100000;
        if(target >= coins[current])
        consider = 1 + countcoins( coins , current , target - coins[current] , memo);
        
        int notconsider =  countcoins( coins , current + 1, target  , memo);
        memo.put(key , Math.min(consider , notconsider));
        
        return memo.get(key);
    }
}