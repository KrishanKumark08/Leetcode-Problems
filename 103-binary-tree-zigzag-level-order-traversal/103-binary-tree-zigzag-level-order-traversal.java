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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>>ans = new ArrayList<>();
        level(root,ans);
        return ans;
    }
    public void level(TreeNode root,List<List<Integer>> ans)
    {
        if(root==null)
            return ;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level = 0;
        while(q.size()>0)
        {
            int l= q.size();
            List<Integer> arr = new ArrayList<>();
            while(l>0)
            {
                TreeNode cn= q.poll();
                if(cn.left!=null)q.add(cn.left);
                if(cn.right!=null)q.add(cn.right);
                arr.add(cn.val);
                l--;
            }
            if(level%2 != 0)
                Collections.reverse(arr);
            ans.add(arr);
            level++;
        }
    }
}