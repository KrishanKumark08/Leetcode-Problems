class Solution {
    public int numSquares(int n) {
        double d = Math.sqrt(n);
        int s = (int)Math.floor(d);
        
        if(n==s*s)
            return 1;
        
        int[][] arr = new int[s+1][n+1];
        
        return minSquares(2, n, arr);
        
    }
    public int minSquares(int currentIndex, int s, int[][] memo){
        
        if(s < currentIndex*currentIndex){
            return s;
        }
        
        if(memo[currentIndex][s]!=0){
            return memo[currentIndex][s];
        }
        
        int consider = 101;
        if(currentIndex * currentIndex <= s){
            consider = 1 + minSquares(currentIndex, s - currentIndex*currentIndex, memo);
        }
        
        int notConsider = minSquares(currentIndex + 1, s, memo);
        
        memo[currentIndex][s] = Math.min(consider, notConsider);
        return memo[currentIndex][s];
        
        
    }
}