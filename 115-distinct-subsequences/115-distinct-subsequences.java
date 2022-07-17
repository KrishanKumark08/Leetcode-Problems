class Solution {
    public int numDistinct(String s, String t) {
        int cs = s.length();
        int ct = t.length();
        int[][] memo = new int[cs + 1][ct + 1];
        for(int j = 0; j <= ct; j++){
            memo[cs][j] = 0;
        }
        
        for(int i = 0; i <= cs; i++){
            memo[i][ct] = 1;
        }
        
        for(int i = cs - 1; i >= 0; i--){
            for(int j = ct - 1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    memo[i][j] = memo[i + 1][j + 1] + memo[i + 1][j];
                }
                else{
                    memo[i][j] = memo[i + 1][j];
                }
            }
        }
        
        return memo[0][0];
        
    }
    
    
    private int totalWays(String s, String t, int cs, int ct, HashMap<String, Integer> memo){
        if(ct >= t.length()){
            return 1;
        }
        if(cs >= s.length()){
            return 0;
        }
        
        String currentKey = cs + "_" + ct;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        if(s.charAt(cs) == t.charAt(ct)){
            memo.put(currentKey, totalWays(s, t, cs + 1, ct + 1, memo) + totalWays(s, t, cs + 1, ct, memo));
            return memo.get(currentKey);
        } 
        
        memo.put(currentKey, totalWays(s, t, cs + 1, ct, memo));
        return memo.get(currentKey);
        
    }
}