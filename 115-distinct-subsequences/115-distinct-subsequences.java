class Solution {
    public int numDistinct(String s, String t) {
        return totalWays(s, t, 0, 0, new HashMap<>());
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