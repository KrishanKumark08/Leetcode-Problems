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
    public int sumEvenGrandparent(TreeNode root) {
        return evenValuedGrandParent(root, null, null);
    }
    
    private int evenValuedGrandParent(TreeNode root, TreeNode parent, TreeNode grandParent){
        if(root == null){
            return 0;
        }
    
        if(grandParent == null || grandParent.val % 2 != 0){
            return evenValuedGrandParent(root.left, root, parent) + evenValuedGrandParent(root.right, root, parent);
        }
        else{
            if(grandParent.val % 2 == 0){
                return root.val + evenValuedGrandParent(root.left, root, parent) + evenValuedGrandParent(root.right, root, parent);
            }
        }
        return 0;
    }
}