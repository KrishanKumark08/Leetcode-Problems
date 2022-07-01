class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j <= i; j++){
                String wordToCheck = s.substring(j, i + 1);
                System.out.println(wordToCheck);
                if(wordDict.contains(wordToCheck)){
                    if(j > 0)
                        dp[i] += dp[j - 1];
                    else
                        dp[i] = 1;
                }
            }
        }
        
        return dp[s.length() - 1] > 0;
        
    }
}