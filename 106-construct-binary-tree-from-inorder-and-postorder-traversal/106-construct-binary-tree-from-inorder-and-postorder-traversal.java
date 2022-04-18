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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = inorder.length - 1;
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            memo.put(inorder[i], i);
        }
        
        return constructTree(postorder, inorder, 0, postorder.length - 1, memo);
    }
    
    private TreeNode constructTree(int[] postorder, int[] inorder, int left, int right, HashMap<Integer, Integer> memo){
        
        if(left > right){
            return null;
        }
        
        int currVal = postorder[postIndex];
        postIndex--;
        
        TreeNode root = new TreeNode(currVal);
        
        int i = -1;
        i = memo.get(currVal);
        
        root.right = constructTree(postorder, inorder, i + 1, right, memo);
        root.left = constructTree(postorder, inorder, left, i - 1, memo);
        
        
        return root;
        
    }
}