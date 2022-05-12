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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        getpaths(root,list,"");
        return list;
    }
    private void getpaths(TreeNode root,List<String> list,String h)
    {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
        {
            h=h+Integer.toString(root.val);
            list.add(h);
            return;
        }
        h=h+Integer.toString(root.val)+"->";
        getpaths(root.left,list,h);
        getpaths(root.right,list,h);
        return ;
    }
}