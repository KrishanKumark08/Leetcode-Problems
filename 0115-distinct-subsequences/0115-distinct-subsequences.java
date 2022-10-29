class Solution {
    public int numDistinct(String s, String t) {
        return total(s, 0, t, 0, new HashMap<String, Integer>());
    }
    
    private int total(String s, int ci, String t, int ti, HashMap<String, Integer> memo){
        if(ti == t.length()){
            return 1;
        }
        if(ci == s.length()){
            return 0;
        }
        
        String currentKey = ci + "_" + ti;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int equal = 0;
        
        if(s.charAt(ci) == t.charAt(ti)){
            equal = total(s, ci + 1, t, ti + 1, memo);
        }
        
        int notequal = total(s, ci + 1, t, ti, memo);
        memo.put(currentKey, equal + notequal);
        return memo.get(currentKey);
    }
    
}