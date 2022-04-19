/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        
        List<Integer> answer = new ArrayList<>();
        
        if(root == null){
            return answer;
        }
        
        TreeNode curr = root;
        
        while(curr != null || !stack1.isEmpty()){
            if(curr != null){
                stack1.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = stack1.peek().right;
                
                if(temp == null){
                    temp = stack1.pop();
                    answer.add(temp.val);
                    
                    while(!stack1.isEmpty() && temp == stack1.peek().right){
                        temp = stack1.pop();
                        answer.add(temp.val);
                    }
                    
                }
                else{
                    curr = temp;
                }
                
            }
            
            
            
        }
        
        return answer;
    }
}