class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String op:ops){
            if(op.equals("C")){
                stack.pop();
            }
            else if(op.equals("D")){
                int prev = stack.peek();
                stack.push(2*prev);
            }
            else if(op.equals("+")){
                int firstPrev = stack.pop();
                int secondPrev = stack.peek();
                stack.push(firstPrev);
                stack.push(firstPrev + secondPrev);
            }
            else {
                stack.push(Integer.parseInt(op));
            }
        }
        
        int sum = 0;
        while(!stack.isEmpty()){
            int ele = stack.pop();
            sum += ele;
        }
        
        return sum;
    }
}