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
        List<Integer> ans = inorderTraversal(root);
        int[] arr = new int[ans.size()];
        int j =0;
        for(int i:ans)
        {
            arr[j] = i;
            j++;
        }
       return sortedArrayToBST(arr);
    }
     public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        int count =1;
        while(count==1)
        {
            while(root!=null )
            {
                stack.push(root);
                root = root.left;
            }
            if(stack.size()==0)
                break;
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
     public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==1)
            return new TreeNode(nums[0]);
        TreeNode root = new TreeNode(0);
        return arraytobst(nums,0,nums.length-1,(0+nums.length-1)/2,root);
          
    }
    private TreeNode arraytobst(int[] nums,int l ,int r,int mid,TreeNode root)
    {
        if(l>r)
            return null;
        
        root = new TreeNode(nums[mid]);
        root.left = arraytobst(nums,l ,mid-1,(l+mid-1)/2,root.left);
        root.right = arraytobst(nums,mid+1 ,r,(r+mid+1)/2,root.right);
        return root;
    }
}