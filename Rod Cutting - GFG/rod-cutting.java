// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int N) {
        //code here
       int[][] dp = new int[N+1][N+1];
       
       for(int current = N-1 ; current>=0 ; current--){
           for(int n = 1 ; n <= N ; n++){
                int consider=0;
                if(n >= current+1)
                consider = price[current]+dp[current][n-current-1];
                int notconsider=  dp[current+1][n];
                dp[current][n] = Math.max(consider,notconsider);
           }
       }
        
        return dp[0][N];
    }
}