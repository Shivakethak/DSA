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
    public int countNodes(TreeNode root) {
        return count(root);
    }
    public int count(TreeNode root){
        if(root==null) return 0;
        int leftHeight =height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight==rightHeight){ 
            int leftNodes = (1<<leftHeight);
            return leftNodes + count(root.right);
        }
        int rightNodes = (1<<rightHeight);
        return rightNodes + count(root.left);
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        int left = height(root.left);
        return left+1;
    } 
}