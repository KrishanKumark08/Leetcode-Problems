//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG
{
    static int segmentTree[];
    static int n;
    static int[] nums;
    
    public static int[] constructST(int nums[], int n)
    {
        n = nums.length;
        nums = nums;
        segmentTree = new int[4*n];
        Arrays.fill(segmentTree, Integer.MAX_VALUE); // Default Value is MAX_VALUE
        constructSegmentTree(nums, 0, n - 1, segmentTree, 0);
        
        return segmentTree;
        
    }
    
    private static void constructSegmentTree(int[] nums, int start, int end, int[] segmentTree, int currentIndex){
        if(start == end){
            segmentTree[currentIndex] = nums[start];
            return;
        }

        int mid = start + (end - start)/2;

        constructSegmentTree(nums, start, mid, segmentTree, 2*currentIndex + 1);
        constructSegmentTree(nums, mid + 1, end, segmentTree, 2*currentIndex + 2);

        segmentTree[currentIndex] = Math.min(segmentTree[2*currentIndex + 1], segmentTree[2*currentIndex + 2]);
        return;

    }
    
    
    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int segmentTree[], int n, int l, int r)
    {
       return getMinQuery(segmentTree, l, r, 0, n - 1, 0);
    }
    
    private static int getMinQuery(int[] segmentTree, int left, int right, int start, int end, int currentIndex){
        // No OverLapping Condition
        if (end < left || start > right){
            return Integer.MAX_VALUE;  // Default Value is MAX_VALUE
        }

        // Complete overLapping
        if(start >= left && end <= right){
            return segmentTree[currentIndex];
        }

        // Partial OverLapping

        int mid = start + (end - start)/2;
        int leftCall = getMinQuery(segmentTree, left, right, start, mid, 2*currentIndex+1);
        int rightCall = getMinQuery(segmentTree, left, right, mid + 1, end, 2*currentIndex + 2);

        return Math.min(leftCall, rightCall);

    }
    
    
    
}