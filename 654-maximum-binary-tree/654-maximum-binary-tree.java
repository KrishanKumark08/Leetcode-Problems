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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBT(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaximumBT(int[] nums, int left, int right){
        
        if(left > right ){
            return null;
        }
        
        int node = left;
        
        int i = left;
        int max = Integer.MIN_VALUE;
        while(i <= right && i < nums.length){
            if(nums[i] > max){
                max = nums[i];
                node = i;
            }
            i++;
        }

        //System.out.println("Left = " + left + " Right = "+right+" node = "+node);
        
        TreeNode root = new TreeNode(nums[node]);
        //System.out.println("Left");
        root.left = constructMaximumBT(nums, left, node - 1);
        //System.out.println("Right");
        root.right = constructMaximumBT(nums, node + 1, right);
        
        return root;
        
    }
}