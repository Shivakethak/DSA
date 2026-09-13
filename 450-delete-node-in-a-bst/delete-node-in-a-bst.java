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
    public TreeNode deleteNode(TreeNode root, int key) {
        return DeleteNode(root,key);
    }
    private TreeNode DeleteNode(TreeNode root,int key){
        if(root==null)  return null;
        if(root.val==key) {
           return Helper(root);
        }
        if(root.val > key){
            root.left = DeleteNode(root.left,key);
        }else{
            root.right = DeleteNode(root.right,key);
        }
        return root;
        }
    private TreeNode Helper(TreeNode root){
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        else{
            TreeNode rightMost = findRightMost(root.left);
            rightMost.right = root.right;
            return root.left;
    }
    }
    private TreeNode findRightMost(TreeNode root){
         while(root.right!=null){
            root = root.right;
         }
         return root;
    }
    }
