// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int left = 0;
        int acquire = 0;
        int answer = -1;
        HashMap<Character, Integer> memo = new HashMap<>();
        
        for(acquire = 0; acquire < s.length(); acquire++){
            char currentChar = s.charAt(acquire);
            
            memo.put(currentChar, memo.getOrDefault(currentChar, 0) + 1);
            
            if(memo.size() < k){
                continue;
            }
            else if(memo.size() == k){
                answer = Math.max(answer, acquire - left + 1);
            }
            else{
                while(left <= acquire && memo.size() > k){
                    char leftMostChar = s.charAt(left);
                    memo.put(leftMostChar, memo.get(leftMostChar) - 1);
                    
                    if(memo.get(leftMostChar) == 0){
                        memo.remove(leftMostChar);
                    }
                    left++;
                }
            }
            
        }
        
        return answer;
    
    }
}