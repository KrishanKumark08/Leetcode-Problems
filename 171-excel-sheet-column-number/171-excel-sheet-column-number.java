class Solution {
    public int titleToNumber(String col) {
        int sum = 0;
        
        for(int i = 1; i < col.length() ;i++)
        {
            sum = sum + (int)Math.pow(26 , i);
        }
        
        for(int i = col.length() - 1 ; i>=0 ; i--)
        {
            sum = sum + (int)Math.pow(26 , col.length() - i - 1) * ((int)col.charAt(i)-64-1) ;
        }
        return sum+1;
    }
}