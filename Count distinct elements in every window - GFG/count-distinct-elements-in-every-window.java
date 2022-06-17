// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> memo = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < k - 1; i++){
            int currentVal = arr[i];
            memo.put(currentVal, memo.getOrDefault(currentVal, 0) + 1);
        }
        
        for(int i = k - 1; i < n; i++){
            int currentVal = arr[i];
            memo.put(currentVal, memo.getOrDefault(currentVal, 0) + 1);
            
            list.add(memo.size());
            
            int removeVal = arr[i - k + 1];
            memo.put(removeVal, memo.getOrDefault(removeVal, 0) - 1);
            if(memo.get(removeVal) == 0){
                memo.remove(removeVal);
            }
        }
        return list;
    }
}

