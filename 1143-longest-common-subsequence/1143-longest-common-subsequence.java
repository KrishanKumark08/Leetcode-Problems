class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return longest(text1, text2, n, m, 0, 0, new HashMap<>());
    }
    
    private int longest(String s1, String s2, int n, int m, int ci1, int ci2, HashMap<String, Integer> memo){
        
        if(ci1 >= n || ci2 >= m){
            return 0;
        }
        
        String currentKey = ci1 + "_" + ci2;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        if(s1.charAt(ci1) == s2.charAt(ci2)){
            int ans = 1 + longest(s1, s2, n, m, ci1 + 1, ci2 + 1, memo);
            memo.put(currentKey, ans);
            return ans;
        }
        else{
            int ans = Math.max(longest(s1, s2, n, m, ci1, ci2 + 1, memo), longest(s1, s2, n, m, ci1 + 1, ci2, memo));
            memo.put(currentKey, ans);
            return ans;
        }
        
    }
    
    
}