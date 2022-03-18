class Solution {
    public int uniquePathsWithObstacles(int[][] obstacle) {
        if(obstacle[0][0]==1)
            return 0;
        int m=obstacle.length;
        int n=obstacle[0].length;
       return unique(0,0,m,n,obstacle,new HashMap<>());
    }
    private int unique(int r,int c,int m,int n,int[][] obstacle,HashMap<String,Integer> memo)
    {
        if(r==m-1&&c==n-1)
            return 1;
        String key=r+"_"+c;
        if(memo.containsKey(key))
            return memo.get(key);
        int h=0,d=0;
        if(r+1<m&&obstacle[r+1][c]==0)
            h=unique(r+1,c,m,n,obstacle,memo);
        if(c+1<n&&obstacle[r][c+1]==0)
            d=unique(r,c+1,m,n,obstacle,memo);
        memo.put(key,h+d);
        return d+h;
    }
}