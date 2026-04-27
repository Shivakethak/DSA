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
    public int diameterOfBinaryTree(TreeNode root) {
        return Diameter(root);
    }
    public int Diameter(TreeNode root){
        if(root==null) return 0;
        int left = Height(root.left);
        int right = Height(root.right);
        int dia = left + right ; 
        int Left = Diameter(root.left);
        int Right = Diameter(root.right);
        return Math.max(Math.max(Left,Right),dia);
       
    }
    public int Height(TreeNode root){
        if(root==null) return 0;
        int left = Height(root.left);
        int right = Height(root.right);
        return Math.max(left,right)+1;
    }
}