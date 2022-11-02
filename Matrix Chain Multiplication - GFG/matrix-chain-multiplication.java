//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        int dp[][] = new int[n+1][n+1];
        
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }
        return minStep(1, n-1, arr, dp);
    }
    
    private static int minStep(int i, int j, int arr[], int dp[][]){
        if(i == j){
            return 0; 
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int k = i; k < j; k++){
            int steps = arr[i-1]*arr[k]*arr[j] + minStep(i, k, arr, dp) + minStep(k + 1, j, arr, dp);
            mini = Math.min(steps, mini);
            
        }
        
        return dp[i][j] = mini;
        
    }
    
}