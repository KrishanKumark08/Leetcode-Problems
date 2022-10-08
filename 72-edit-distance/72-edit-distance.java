class Solution {
    public int minDistance(String word1, String word2) {
        return minOperations(word1, word2, 0, 0, new HashMap<String, Integer>());
    }
    
    private int minOperations(String s1, String s2, int i1, int i2, HashMap<String, Integer> memo){
        
        if(i1 == s1.length()){
            return s2.length() - i2;
        }
        
        if(i2 == s2.length()){
            return s1.length() - i1;
        }
        
        String currKey = i1 + "_" + i2;
        if(memo.containsKey(currKey)){
            return memo.get(currKey);
        }
        
        if(s1.charAt(i1) == s2.charAt(i2)){
            int ans = minOperations(s1, s2, i1 + 1, i2 + 1, memo);
            memo.put(currKey, ans);
            return ans;
        }
        else{
            int insert = minOperations(s1, s2, i1, i2 + 1, memo);
            int delete = minOperations(s1, s2, i1 + 1, i2, memo);
            int replace = minOperations(s1, s2, i1 + 1, i2 + 1, memo);
            int ans =  1 + Math.min(insert, Math.min(delete, replace));
            memo.put(currKey, ans);
            return ans;
        }
        
    }
    
}