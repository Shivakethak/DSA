/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCAFORBST(root,p,q);
    }
    // private TreeNode LCA(TreeNode root,TreeNode p,TreeNode q){
    //     if(root==null) return null;
    //     if(root == p || root == q ) return root;
    //     TreeNode left = LCA(root.left,p,q);
    //     TreeNode right = LCA(root.right,p,q);
    //     if(left!=null && right != null) return root;
    //     if(left!=null) return left;
    //     if(right!=null) return right;
    //     return null;
    // }
    private TreeNode LCAFORBST(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return null;
        if(root == p || root == q ) return root;
        if(root.val>p.val && root.val<q.val ||root.val>q.val && root.val<p.val) return root;
        if(root.val>p.val && root.val>q.val) return LCAFORBST(root.left,p,q);
        if(root.val<p.val && root.val<q.val) return LCAFORBST(root.right,p,q);
        return null;
    }
    }
