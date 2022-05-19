/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentmap = new HashMap<>();
        parentnodes(root,null,parentmap);
        List<Integer> answer = new ArrayList<>();
        knodes(target,k,answer,new HashSet<>(),parentmap);
        return answer;
    }
    private void parentnodes(TreeNode root,TreeNode parent,HashMap<TreeNode,TreeNode> parentmap)
    {
        if(root==null)
            return;
        parentmap.put(root,parent);
        parentnodes(root.left,root,parentmap);
        parentnodes(root.right,root,parentmap);
        return;
    }
    private void knodes(TreeNode root,int k,List<Integer> answer,HashSet<Integer>visited,HashMap<TreeNode,TreeNode> parentmap)
    {
        if(root==null || k<0 ||visited.contains(root.val))
            return;
         visited.add(root.val);
        if(k==0)
        {
                answer.add(root.val);
                return;
        }
        visited.add(root.val);
        knodes(root.left,k-1,answer,visited,parentmap);
        knodes(root.right,k-1,answer,visited,parentmap);
        knodes(parentmap.get(root),k-1,answer,visited,parentmap);
        return;
    }
}