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
    public int cutRod(int price[], int n) {
        int[][] memo = new int[n + 1][n + 1];
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j < n + 1; j++){
                if(i + 1 <= j){
                    memo[i][j] = Math.max(price[i] + memo[i][j - i - 1], memo[i + 1][j]);
                }
                else{
                    memo[i][j] = memo[i + 1][j];
                }
            }
        }
        return memo[0][n];
    }
}