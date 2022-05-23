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
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0 ;i<nums.length ; i++)
        {
            map.put(nums[i], i);
        }
        
        return maximumbinarytree(nums,0,nums.length-1,map);
        
        
    }
    public TreeNode maximumbinarytree(int[] nums,int l,int r,HashMap<Integer,Integer> map)
    {
        if(l > r)
            return null;
        
        int arr[] = new int[r-l+1];
        int j =0;
        for(int i=l;i<=r;i++)
        {
            arr[j] = nums[i];
            j++;
        }
        
        Arrays.sort(arr);
        
        int newval = arr[arr.length-1];
        TreeNode root = new TreeNode(newval);
        
        int mid = map.get(newval);
        
            
        root.left =  maximumbinarytree(nums , l, mid-1, map);
        root.right =  maximumbinarytree(nums ,mid+1, r, map);
        
        return root;
    }
}