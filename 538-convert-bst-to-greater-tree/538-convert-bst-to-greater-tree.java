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
    public TreeNode convertBST(TreeNode root) {
    List<Integer> arr= new ArrayList<>();
        inorder(root,arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        for(int i = arr.size()-1;i>=0;i--)
        {
            sum = sum + arr.get(i);
            map.put(arr.get(i),sum);
        }
        populatebst(root,map);
        return root;
    }
    private void populatebst(TreeNode root,HashMap<Integer,Integer> map)
    {
        if(root==null)
            return;
        root.val = map.get(root.val);
        populatebst(root.left,map);
        populatebst(root.right,map);
        return;
    }
    public void inorder(TreeNode root,List<Integer> arr)
    {
        if(root==null)
            return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return;
    }
}