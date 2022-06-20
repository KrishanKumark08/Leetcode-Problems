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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         HashMap<Integer, Integer> inorderHashMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderHashMap.put(inorder[i], i);
        }
        int arr[] = new int[1];
        arr[0] = 0;
        return construct(preorder,arr,inorderHashMap,0,inorder.length-1);
    }
    
    private TreeNode construct(int[] preorder,int[] arr,HashMap <Integer,Integer> inorderHashMap,int l,int r)
    {
        if(l>r)
            return null;
        
        TreeNode root = new TreeNode(preorder[arr[0]]);
        int index = inorderHashMap.get(preorder[arr[0]]);
        arr[0] = arr[0] +1;
        root.left = construct(preorder,arr,inorderHashMap,l,index-1);
        root.right = construct(preorder,arr,inorderHashMap,index+1,r);
        
        return root;
    }
}
   