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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       height(root);
       return max;
    }
    // public int diameter(TreeNode root){
    //     if(root==null) return 0;
    //     int leftheight = height(root.left);
    //     int rightheight = height(root.right);
    //     max = Math.max(max,leftheight+rightheight);
    //     diameter(root.left);
    //     diameter(root.right);
    //     return max;

    // }
    public int height(TreeNode node){
        if(node==null) return 0;
        int leftheight = height(node.left);
        int rightheight = height(node.right);
        max = Math.max(max,leftheight+rightheight);
        return Math.max(leftheight,rightheight)+1;
    }
}