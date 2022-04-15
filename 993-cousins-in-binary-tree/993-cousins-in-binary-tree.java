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

class Pair{
    int parent;
    int depth;

    Pair(){}

    Pair(int parent, int depth){
        this.parent = parent;
        this.depth = depth;
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Pair pairOfX = new Pair();
        calcParentAndDepth(root, x, pairOfX, 0, 0);
        
        Pair pairOfY = new Pair();
        calcParentAndDepth(root, y, pairOfY, 0, 0);
        
        return pairOfX.parent != pairOfY.parent && pairOfX.depth == pairOfY.depth;
        
    }
    
    private void calcParentAndDepth(TreeNode root, int node, Pair pair, int parent, int depth){
        
        if(root == null){
            return;
        }
        
        if(root.val == node){
            pair.parent = parent;
            pair.depth = depth;
            return;
        }
        
        calcParentAndDepth(root.left, node, pair, root.val, depth + 1);
        calcParentAndDepth(root.right, node, pair, root.val, depth + 1);
        
    }
    
}