// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}// } Driver Code Ends

//User function Template for Java

class Solution{
    
    int longestCommonSubstr(String s1, String s2, int n, int m){
        int[] ans = new int[1];
        
        int[][] memo = new int[n+1][m+1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        
        longest(s1, s2, n, m, 0, 0, ans, 0, memo);
        return ans[0];
    }
    
    private void longest(String s1, String s2, int n, int m, int ci1, int ci2, int[] ans, int currentLength, int[][] memo){
        ans[0] = Math.max(ans[0], currentLength);
        
        if(ci1 >= n || ci2 >= m){
            return ;
        }
        
        if(s1.charAt(ci1) == s2.charAt(ci2)){
            longest(s1, s2, n, m, ci1 + 1, ci2 + 1, ans, currentLength + 1, memo);
            longest(s1, s2, n, m, ci1, ci2 + 1, ans, 0, memo);
            longest(s1, s2, n, m, ci1 + 1, ci2, ans, 0, memo);
        }
        else{
            if(memo[ci1][ci2] != -1){
                return;
            }
            
            memo[ci1][ci2] = 1;
            longest(s1, s2, n, m, ci1, ci2 + 1, ans, 0, memo);
            longest(s1, s2, n, m, ci1 + 1, ci2, ans, 0, memo);
        }
        return;
    }
}