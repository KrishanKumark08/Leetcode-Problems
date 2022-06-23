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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
       if(root==null)
            return list;
        arr.add(root.val);
        pathsum(root,targetSum,list,arr);
       return list;
    }
    private void pathsum(TreeNode root,int target,List<List<Integer>> list,List<Integer> arr)
    {
        if(root==null)
            return ;
        if(root.left==null&&root.right==null)
        {
            target=target-root.val;
            if(target==0)
            {
                //arr.add(root.val);
                list.add(new ArrayList(arr));
            }
            return ;
        }
        if(root.right!=null)
        {
            arr.add(root.right.val);
            pathsum(root.right,target-root.val,list,arr);
            arr.remove(arr.size()-1);
        }
         if(root.left!=null)
        {
            arr.add(root.left.val);
            pathsum(root.left,target-root.val,list,arr);
            arr.remove(arr.size()-1);
        }
        return;
    }
}