// { Driver Code Starts
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
    int matrixMultiplication(int n, int arr[])
    {
        int[][] memo = new int[arr.length + 1][arr.length + 1];
        for(int[] a:memo){
            Arrays.fill(a, -1);
        }
        return minOperations(arr, 1, n - 1, memo);
    }
    private int minOperations(int arr[], int start, int end, int[][] memo){
        if(start >= end){
            return 0;
        }
        
        if(memo[start][end] != -1){
            return memo[start][end];
        }
        
        int currentAns = Integer.MAX_VALUE;
        for(int k = start; k < end; k++){
            int tempAns = minOperations(arr, start, k, memo) + minOperations(arr, k + 1, end, memo) + arr[start - 1]*arr[k]*arr[end];
            currentAns = Math.min(tempAns, currentAns);
        }
        
        return memo[start][end] = currentAns;
        
    }
}