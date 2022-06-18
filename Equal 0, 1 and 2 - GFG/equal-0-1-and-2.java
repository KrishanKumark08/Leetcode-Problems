// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String s) 
    { 
        HashMap<String, Integer> memo = new HashMap<>();
        int zeroCount = 0;
        int onesCount = 0;
        int twosCount = 0;
        
        String str = (onesCount - zeroCount) + "#" + (twosCount - onesCount);
        memo.put(str, 1);
        long answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            char currentVal = s.charAt(i);
            if(currentVal == '0'){
                zeroCount++;
            }
            else if(currentVal == '1'){
                onesCount++;
            }
            else{
                twosCount++;
            }
            
            str = (onesCount - zeroCount) + "#" + (twosCount - onesCount);
            if(memo.containsKey(str)){
                answer += memo.get(str);
                memo.put(str, memo.get(str) + 1);
            }
            else{
                memo.put(str, 1);
            }
        }

        return answer;
    }
} 