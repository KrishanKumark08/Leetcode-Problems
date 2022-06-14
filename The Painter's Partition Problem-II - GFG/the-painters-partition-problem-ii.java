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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution{
     long minTime(int[] arr,int n,int k){
        long start = 1;
        long totalSum = 0;
        
        for(int ele:arr){
            totalSum += ele;
        }
        
        long end = totalSum;
        
        long answer = -1; 
        
        // Same Code As Allocate Minimum Number of Pages
        
        //We can use start as well as end as long variables as due to large values of arr
        // totalSum might overflow in integer.
        // With DP it is MCM Variation.
        
        while(start <= end){
            long mid = start + (end - start)/2;
            
            if(isPossible(arr, n, k, mid)){
                answer = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return answer;
    }
    
    private boolean isPossible(int[] pages, int n, int students, long boundVal){
        int studentsCount = 1;
        int currentSum = 0;
        
        for(int currentPage: pages){
            if(currentPage > boundVal){
                return false;
            }
            else if(currentSum + currentPage <= boundVal){
                currentSum += currentPage;
            }
            else{
                studentsCount += 1;
                currentSum = currentPage;
            }
            
            if(studentsCount > students){
                return false;
            }
            
        }
        return true;   
    }
}


