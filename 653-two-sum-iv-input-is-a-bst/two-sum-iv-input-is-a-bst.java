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
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return FindTarget(root,k);
    }
    private boolean FindTarget(TreeNode node,int k){
    if(node==null) return false;
    if(set.contains(k-node.val)) return true;
    set.add(node.val);
    if(FindTarget(node.left,k)==true) return true;
    if(FindTarget(node.right,k)==true) return true;
    return false;

    }
}