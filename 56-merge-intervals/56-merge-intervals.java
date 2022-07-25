class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        stack1.push(intervals[0][0]);
        stack2.push(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if(start >= stack1.peek() && start <= stack2.peek()){
                if(end <= stack2.peek()){ // [[1,4],[2,3]] -> ans is -> [1,4]
                    continue;
                }
                stack2.pop();
                stack2.push(end);
            }
            else{
                stack1.push(start);
                stack2.push(end);
            }
        }
        
        int n = stack1.size();
        int[][] arr = new int[n][2];
        
        for(int i = n - 1; i >= 0; i--){
            arr[i][0] = stack1.pop();
            arr[i][1] = stack2.pop();
        }
        
        return arr;
        
    }
}