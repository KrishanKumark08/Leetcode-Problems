class Solution {
    public int minCut(String s) {
        return minimumCuts(s, 0, s.length() - 1, new int[s.length()][s.length()]);
    }
    
    private int minimumCuts(String s, int start, int end, int[][] memo){
        if(start >= end || isPalindrome(s, start, end)){
            return 0;
        }
        
        int currentAns = Integer.MAX_VALUE;
        if(memo[start][end] != 0){
            return memo[start][end];
        }
        
        for(int k = start; k < end; k++){
            if(isPalindrome(s, start, k)){
                int tempAns = 1 + minimumCuts(s, k + 1, end, memo);
                currentAns = Math.min(currentAns, tempAns);
            }
        }
        
        return memo[start][end] = currentAns;
        
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
}