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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solveRightView(root, ans, new HashSet<>(), 0);
        return ans;
    }
    
    private void solveRightView(TreeNode root, List<Integer> ans, HashSet<Integer> set, int level){
        if(root == null){
            return;
        }
        
        if(!set.contains(level)){
            ans.add(root.val);
            set.add(level);
        }
        
        solveRightView(root.right, ans, set, level + 1);
        solveRightView(root.left, ans, set, level + 1);
        
        
    }
}