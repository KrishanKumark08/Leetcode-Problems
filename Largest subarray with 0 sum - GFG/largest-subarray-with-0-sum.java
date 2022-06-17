// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int prefixSum = 0;
        int len = 0;
        
        memo.put(prefixSum, -1);
        
        for(int i = 0; i < n; i++){
            int currentVal = arr[i];
            prefixSum += currentVal;
            
            if(memo.containsKey(prefixSum)){
                int currentLen = i - memo.get(prefixSum);
                len = Math.max(len, currentLen);
            }
            else{
                memo.put(prefixSum, i);
            }
        }
        
        return len;
        
    }
}