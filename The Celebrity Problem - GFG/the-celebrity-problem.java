// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i = 0; i < n; i++){
    	    stack.push(i);
    	}
    	
    	while(stack.size() > 1){
    	    int a = stack.pop();
    	    int b = stack.pop();
    	    
    	    if(M[a][b] == 1){
    	        stack.push(b);
    	    }
    	    else
    	        stack.push(a);
    	}
    	
    	int ans = stack.peek();

    	for(int i = 0; i < n; i++){
    	    if(i!=ans)
    	    if(M[ans][i] == 1 || M[i][ans] != 1){
    	        return -1;
    	    }
    	}
    	return ans;
    }
}