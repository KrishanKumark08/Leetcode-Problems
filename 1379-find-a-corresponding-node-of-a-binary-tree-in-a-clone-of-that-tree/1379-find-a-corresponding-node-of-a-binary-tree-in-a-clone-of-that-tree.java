/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        HashMap<Integer, TreeNode> memo = new HashMap<>();
        
        targetCopy(cloned, target, memo);
        
        return memo.get(1);
        
    }
    
    private void targetCopy(TreeNode cloned, TreeNode target, HashMap<Integer, TreeNode> memo){
        
        if(cloned == null){
            return ;
        }
        
        if(cloned.val == target.val){
            memo.put(1, cloned);
        }
        
        targetCopy(cloned.left, target, memo);
        targetCopy(cloned.right, target, memo);
        
        return;
        
    }
    
}