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
        Stack<TreeNode> stack2 = new Stack<>();
        
        List<Integer> answer = new ArrayList<>();
        
        if(root == null){
            return answer;
        }
        
        stack1.push(root);
        
        while(!stack1.isEmpty()){
            TreeNode currentNode = stack1.pop();
            
            stack2.push(currentNode);
            
            if(currentNode.left != null){
                stack1.push(currentNode.left);
            }
            
            if(currentNode.right != null){
                stack1.push(currentNode.right);
            }
            
        }
        
        while(!stack2.isEmpty()){
            answer.add(stack2.pop().val);
        }
        
        return answer;
    }
}