class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '}' || c == ']' || c == ')'){
                if(stack.empty()){
                    return false;
                }
                else{
                    if(c == '}' && stack.peek() == '{')
                        stack.pop();
                    else if(c == ']' && stack.peek() == '[')
                        stack.pop();
                    else if(c == ')' && stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                }
            }
            else{
                stack.push(c);
            }
        }
    
        return stack.isEmpty();
        
    }
}