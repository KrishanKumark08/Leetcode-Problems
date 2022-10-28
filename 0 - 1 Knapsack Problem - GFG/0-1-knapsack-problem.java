//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int capacity, int weights[], int values[], int n) 
    { 
        int memo[][] = new int[n+1][capacity + 1];
        
        for(int j = 0; j < capacity + 1; j++){
            memo[n][j] = 0;
        }
        
        for(int i = n - 1; i >= 0; i--){
            for(int weight = 1; weight <= capacity; weight++){
                int consider = 0;
                if(weights[i] <= weight){
                    consider = values[i] + memo[i+1][weight - weights[i]];
                }
                int notConsider = memo[i+1][weight];
                memo[i][weight] = Math.max(consider, notConsider);
            }
        }
        
        return memo[0][capacity];
        
    } 
}
