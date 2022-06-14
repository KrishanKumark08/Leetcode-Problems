// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public int findPages(int[]A,int n,int m)
    {
        int start = 1;
        long totalSum = 0;
        
        for(int ele:A){
            totalSum += ele;
        }
        
        int end = (int)totalSum;
        
        int answer = -1; 
        //We can use start as well as end as long variables as due to large values of A
        // totalSum might overflow in integer.
        // With DP it is MCM Variation.
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(isPossible(A, n, m, mid)){
                answer = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return answer;
    }
    
    private boolean isPossible(int[] pages, int n, int students, int boundVal){
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
};