class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(Integer currentStone:asteroids){
            
            if(currentStone > 0){
                stack.push(currentStone);
            }
            else{
                
                while(!stack.isEmpty() && stack.peek() < -currentStone && stack.peek() > 0){
                    stack.pop();
                }
                
                if(!stack.isEmpty() && stack.peek() == -currentStone){
                    stack.pop();
                }
                else if(!stack.isEmpty() && stack.peek() < 0){
                    stack.push(currentStone);
                }
                else if(stack.isEmpty())
                    stack.push(currentStone);
            }
            
        }
        
        int[] ans = new int[stack.size()];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = stack.peek();
            stack.pop();
        }
        return ans;
    }
}