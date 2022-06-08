// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> memo = new HashMap<>();
        memo.put('^',3);
        memo.put('*',2);
        memo.put('/',2);
        memo.put('+',1);
        memo.put('-',1);
        
        String result = "";
        
        for(int i = 0; i < exp.length(); i++){
            char currentChar = exp.charAt(i);
            
            if(!memo.containsKey(currentChar)){
                if(currentChar == '('){
                    stack.push(currentChar);
                }
                else if(currentChar == ')'){
                    while(!stack.isEmpty() && stack.peek() != '('){
                        result += stack.pop();
                    }
                    stack.pop();
                }
                else{
                    result += currentChar;
                }
            }
            
            else{
                while(!stack.isEmpty() && stack.peek() != '(' && memo.get(stack.peek()) >= memo.get(currentChar)){
                    result += stack.pop();
                }
                stack.push(currentChar);
            }
        }
        
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}