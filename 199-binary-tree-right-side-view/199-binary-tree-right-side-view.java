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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        if(root==null)
        {
            return list;
        }
       // list.add(root.val);
        rightview(root,list,new HashSet<>(),0);
        return list;
    }
    public void rightview(TreeNode root,List<Integer> list,HashSet<Integer>set,int level)
    {
        if(root==null)
            return;
       if(!set.contains(level))
       {
           set.add(level);
           list.add(root.val);
       }
        
         rightview(root.right,list,set,level+1);
         rightview(root.left,list,set,level+1);
        return;
    }
}