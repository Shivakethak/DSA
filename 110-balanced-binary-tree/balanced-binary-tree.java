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
    public boolean isBalanced(TreeNode root) {
        return IsBalanced(root);
    }
    public boolean IsBalanced(TreeNode root){
       if(root==null) return true;
       int left = Height(root.left);
       int right = Height(root.right);
       if(Math.abs(right-left)>1) return false;
       boolean Left = IsBalanced(root.left);
       boolean Right = IsBalanced(root.right);
       if(Left==false || Right==false) return false;
       return true;
    }
    public int Height(TreeNode root){
        if(root==null) return 0;
        int left = Height(root.left);
        int right = Height(root.right);
        return Math.max(left,right)+1;
    }
}