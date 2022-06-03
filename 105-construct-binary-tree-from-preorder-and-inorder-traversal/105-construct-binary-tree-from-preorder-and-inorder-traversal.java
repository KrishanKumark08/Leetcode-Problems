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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            memo.put(inorder[i], i);
        }
        
        return constructTree(preorder, inorder, 0, preorder.length - 1, memo);
    }
    
    private TreeNode constructTree(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> memo){
        
        if(left > right){
            return null;
        }
        
        int currVal = preorder[preIndex];
        preIndex++;
        
        TreeNode root = new TreeNode(currVal);
        
        int i = -1;
        i = memo.get(currVal);
        
        root.left = constructTree(preorder, inorder, left, i - 1, memo);
        root.right = constructTree(preorder, inorder, i + 1, right, memo);
        
        return root;
        
    }
    
}