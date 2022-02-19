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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    return minDiff(arr, n, 0, 0, 0, new HashMap<>());
	} 
	
	private int minDiff(int[] arr, int n, int currentIndex, int firstSum, int secondSum, HashMap<String, Integer> memo){
	    
	    if(currentIndex >= n){
	        return Math.abs(firstSum - secondSum);
	    }
	    
	    String currentKey = currentIndex + "_" + firstSum + "_" + secondSum;
	    if(memo.containsKey(currentKey)){
	        return memo.get(currentKey);
	    }
	    
	    int first = minDiff(arr, n, currentIndex + 1, firstSum + arr[currentIndex], secondSum, memo);
	    int second = minDiff(arr, n, currentIndex + 1, firstSum, secondSum + arr[currentIndex], memo);
	    memo.put(currentKey, Math.min(first, second));
	    return memo.get(currentKey);
	}
	
}
