class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->a.length() - b.length());
        // Because Here we can pick any sequence 
        // Here it is not subsequence
        // so if we sort it 
        // Take this example for reference ["xbc","pcxbcf","xb","cxbc","pcxbc"]
        
        
        int n = words.length;
        int dp[] = new int[n];
        int maxi = 1;
        
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(checkPossible(words[i], words[j]) && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        
        return maxi;
    }
    
    private boolean checkPossible(String s1, String s2){
        if(s1.length() != s2.length() + 1){
            return false;
        }
        
        int first = 0;
        int second = 0;
        
        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        
        return first == s1.length() && second == s2.length();
        
    }
    
}