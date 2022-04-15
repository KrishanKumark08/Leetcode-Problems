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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        
        preOrder(root, list, low, high);
        
        int[] preorder = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            preorder[i] = list.get(i);
        }
        
        return bstFromPreorder(preorder);
        
    }
    
    public void preOrder(TreeNode root, List<Integer> list, int low, int high){
        if(root == null){
            return;
        }
        
        if(root.val >= low && root.val <= high)
        list.add(root.val);
        preOrder(root.left, list, low, high);
        preOrder(root.right, list, low, high);
        
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] preIndex = {0};
        return buildTree(preorder, preIndex, 1001);
    }
    
    private TreeNode buildTree(int[] preorder, int[] preIndex, int boundVal){
        
        if(preIndex[0] >= preorder.length || preorder[preIndex[0]] >= boundVal){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        preIndex[0] += 1;
        
        root.left = buildTree(preorder, preIndex, root.val);
        root.right = buildTree(preorder, preIndex, boundVal);
        
        return root;
        
    }
    
}