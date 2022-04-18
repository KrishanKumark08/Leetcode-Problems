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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, inorder, 0, preorder.length - 1, new int[1]);
    }
    
    private TreeNode constructTree(int[] preorder, int[] inorder, int left, int right, int[] preIndex){
        
        // if(preIndex[0] >= preorder.length){
        //     return null;
        // }
        
        if(left > right){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        
        int i = 0;
        while(i < inorder.length){
            if(inorder[i] == preorder[preIndex[0]]){
                break;
            }
            i++;
        }
        
        preIndex[0]++;
        root.left = constructTree(preorder, inorder, left, i - 1, preIndex);
        root.right = constructTree(preorder, inorder, i + 1, right, preIndex);
        
        return root;
        
    }
    
}