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
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root != null)
            stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            ans.add(currentNode.val);
            if(currentNode.left != null) stack.push(currentNode.left);
            if(currentNode.right != null) stack.push(currentNode.right);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}