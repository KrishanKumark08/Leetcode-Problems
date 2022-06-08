class Solution {
    private int[] nextGreaterElement(int[] heights, int n){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] ans = new int[n];
        
        for(int i = n - 1; i >= 0; i--){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                stack.pop();
            
            ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
    private int[] prevGreaterElement(int[] heights, int n){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                stack.pop();
            
            ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        
        
        int[] next = new int[n];
        next = nextGreaterElement(heights, n);
        
        int[] prev = new int[n];
        prev = prevGreaterElement(heights, n);
        
        for(int i = 0; i < n; i++){
            int length = heights[i];
            
            if(next[i] == -1){
                next[i] = n;
            }
            
            int breadth = next[i] - prev[i] - 1;
            int currentArea = length * breadth;
            maxArea = Math.max(currentArea, maxArea);
            
        }
        return maxArea;
    }
}