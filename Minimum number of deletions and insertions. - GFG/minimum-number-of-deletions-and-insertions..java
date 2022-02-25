// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String text1, String text2) 
	{ 
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
        
        int i = 0;
        int j = 0;
        String str = "";
        while(i != n && j != m){
            if(text1.charAt(i) == text2.charAt(j)){
                str = str + text1.charAt(i);
                i = i + 1;
                j = j + 1;
            }
            else{
                if(memo[i][j + 1] > memo[i + 1][j]){
                    j = j + 1;
                }
                else{
                    i = i + 1;
                }
            }
        }
        
        //System.out.println(str);
        
        return n - memo[0][0] + m - memo[0][0];
	} 
}