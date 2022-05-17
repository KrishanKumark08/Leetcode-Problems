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
    public TreeNode bstFromPreorder(int[] preorder) {
        int arr[] =new int[1];
        arr[0] = 100000;
        return construct(preorder,new int[1],arr);
    }
    
    private TreeNode construct(int[] preorder,int[] index,int[] arr)
    {
        if(index[0] >= preorder.length || preorder[index[0]] > arr[0] )
            return null;
        
        TreeNode root = new TreeNode(preorder[index[0]]);
        int temp = arr[0];
        
        arr[0] = preorder[index[0]];
        index[0]++;
        root.left = construct(preorder,index,arr);
        
        arr[0] = temp;
        root.right = construct(preorder,index,arr);
        
        return root;
    }
}
   