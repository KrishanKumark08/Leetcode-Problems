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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    HashMap<Integer, Integer> inorderHashMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderHashMap.put(inorder[i], i);
        }
        int arr[] = new int[1];
        arr[0] = inorder.length-1;
        return construct(postorder,arr,inorderHashMap,0,inorder.length-1);
    }
    
    private TreeNode construct(int[] postorder,int[] arr,HashMap <Integer,Integer> inorderHashMap,int l,int r)
    {
        if(l>r)
            return null;
        
        TreeNode root = new TreeNode(postorder[arr[0]]);
        int index = inorderHashMap.get(postorder[arr[0]]);
        arr[0] = arr[0] - 1;
        root.right = construct(postorder,arr,inorderHashMap,index+1,r);
         root.left = construct(postorder,arr,inorderHashMap,l,index-1);
        
        return root;
    }
}
   