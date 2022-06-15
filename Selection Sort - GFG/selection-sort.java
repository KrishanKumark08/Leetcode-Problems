// { Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}
// } Driver Code Ends


class Solution
{
	int  select(int arr[], int i)
	{
	    // This Function will be for passes that will calculate the smallest Element in given
	    // unsorted array
        int smallestIndex = i;
        int smallestElement = arr[i];
        int n = arr.length;
        for(int j = i + 1; j < n; j++){
            if(arr[j] < smallestElement){
                smallestIndex = j;
                smallestElement = arr[j];
            }
        }
        
        int temp = arr[i];
        arr[i] = smallestElement;
        arr[smallestIndex] = temp;
        return smallestElement;
        
	}
	
	void selectionSort(int arr[], int n)
	{
	    // Loop will run till n - 1 as last element will automatically be sorted
	    for(int i = 0; i < n - 1; i++){
	        select(arr, i);
	    }
	}
}