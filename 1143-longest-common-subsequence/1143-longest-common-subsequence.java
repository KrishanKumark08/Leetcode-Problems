class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return solve(text1, text2, 0, 0, new int[text1.length()][text2.length()]);
    }
    
    private int solve(String s1, String s2,int cI1, int cI2, int[][] memo){
        if(cI1 >= s1.length() || cI2 >= s2.length()){
            return 0;
        }
        
        if(memo[cI1][cI2] != 0){
            return memo[cI1][cI2];
        }
        
        
        if(s1.charAt(cI1) == s2.charAt(cI2)){
            memo[cI1][cI2] = 1 + solve(s1, s2, cI1 + 1, cI2 + 1, memo);
            return memo[cI1][cI2];
        }
        
        memo[cI1][cI2] = Math.max(solve(s1, s2, cI1 + 1, cI2, memo), solve(s1, s2, cI1, cI2 + 1, memo));
        return memo[cI1][cI2];
        
    }
    
}