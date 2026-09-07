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
        int leftHeight =lh(root.left);
        int rightHeight = rh(root.right);
        if(leftHeight==rightHeight){ 
            int leftNodes = (1<<(leftHeight+1))-1;
            return leftNodes;
        }
        return count(root.right) + count(root.left) +1;
    }
    private int lh(TreeNode root){
        if(root==null) return 0;
        int left = lh(root.left);
        return left+1;
    } 
    private int rh(TreeNode root){
        if(root==null) return 0;
        int right = rh(root.right);
        return right+1;
    } 
}