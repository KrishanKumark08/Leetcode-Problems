// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
       Stack<Integer> stack = new Stack<>();
       
       for(int i = 0; i < S.length(); i++){
           char currentChar = S.charAt(i);
           if(currentChar != '*' && currentChar != '/' && currentChar != '+' && currentChar != '-'){
               stack.push(Character.getNumericValue(currentChar));
           }
           else{
               int firstValue = stack.pop();
               int secondValue = stack.pop();
              
                if(currentChar == '*')
                    stack.push(secondValue * firstValue);
                else if(currentChar == '/')
                    stack.push(secondValue / firstValue);
                else if(currentChar == '+')
                    stack.push(secondValue + firstValue);
                else if(currentChar == '-')
                    stack.push(secondValue - firstValue);
           }
       }
       return stack.peek();
    }
}