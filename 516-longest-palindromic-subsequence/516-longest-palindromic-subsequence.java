class Solution {
    public int longestPalindromeSubseq(String text1) {
        String text2 = new StringBuilder(text1).reverse().toString();
        int n = text1.length();
        int m = text2.length();
        
        int[][] memo = new int[n + 1][m + 1];
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    memo[i][j] = 1 + memo[i + 1][j + 1];
                }
                else{
                    memo[i][j] = Math.max(memo[i][j + 1], memo[i + 1][j]);
                }
            }
        }
        
        return memo[0][0];
    }
}