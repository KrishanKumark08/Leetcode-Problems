class Solution {
    public int tribonacci(int n) {
        return nthTrib(n,new HashMap<Integer,Integer>());
    }
    public int nthTrib(int n,HashMap<Integer,Integer> memo)
    {
        if(n==2 || n==1)
            return 1;
        if(n==0)
            return 0;
        
        int currentKey = n;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int a = nthTrib(n-1,memo);
        int b = nthTrib(n-2,memo);
        int c = nthTrib(n-3,memo);
        
        memo.put(n,a + b +c);
        
        return memo.get(currentKey);
    }
}