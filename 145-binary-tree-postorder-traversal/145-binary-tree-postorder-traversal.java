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
    TreeNode node;
    int count;
    Pair(){}
    Pair(TreeNode node, int count){
        this.node = node;
        this.count = count;
    }
}

class Solution {
    
    // Calculating all the traversals in 1 GO
    // TC : O(3*n)
    // SC : O(4*n)
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        
        if(root == null){
            return postorder;
        }
        
        Stack<Pair> stack = new Stack<>();
        
        Pair pair= new Pair(root, 1);
        stack.push(pair);
        
        while(!stack.isEmpty()){
            Pair currPair= stack.pop();
            
            if(currPair.count == 1){
                preorder.add(currPair.node.val);
                currPair.count++;
                stack.push(currPair);
                if(currPair.node.left != null){
                    stack.push(new Pair(currPair.node.left, 1));
                }
            }
            else if(currPair.count == 2){
                inorder.add(currPair.node.val);
                currPair.count++;
                stack.push(currPair);
                if(currPair.node.right != null){
                    stack.push(new Pair(currPair.node.right, 1));
                }
            }
            else if(currPair.count == 3){
                postorder.add(currPair.node.val);
            }
        }
        
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
        
        return postorder;
    }
}