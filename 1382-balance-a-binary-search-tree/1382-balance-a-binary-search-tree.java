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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        
        inorder(root, inOrder);
        
        int[] nums = new int[inOrder.size()];
        for(int i = 0; i < inOrder.size(); i++){
            nums[i] = inOrder.get(i);
        }
        return constructBSTFromSortedArray(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructBSTFromSortedArray(int[] nums, int left, int right){
        
        if(left > right ){
            return null;
        }
        
        int mid = (left + right)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBSTFromSortedArray(nums, left, mid - 1);
        root.right = constructBSTFromSortedArray(nums, mid + 1, right);
        
        return root;
        
    }
    
    private void inorder(TreeNode root, List<Integer> answer){
        
        if(root == null){
            return;
        }
        
        inorder(root.left, answer);
        answer.add(root.val);
        inorder(root.right, answer);
        
        return;
        
    }
    
}