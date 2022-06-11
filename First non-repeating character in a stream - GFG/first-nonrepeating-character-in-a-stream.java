// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution
{
    public String FirstNonRepeating(String A)
    {
       HashMap<Character, Integer> memo = new HashMap<>();
       Queue<Character> queue = new LinkedList<>();
       
       String ans = "";
       
       for(int i = 0; i < A.length(); i++){
           char currentChar = A.charAt(i);
           
           memo.put(currentChar, memo.getOrDefault(currentChar, 0) + 1);
           queue.offer(currentChar);
           
           while(!queue.isEmpty()){
               if(memo.get(queue.peek()) > 1){
                   queue.poll();
               }
               else{
                   ans += queue.peek();
                   break;
               }
           }
           
           if(queue.isEmpty()){
               ans += '#';
           }
           
       }
       return ans;
    }
}