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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxpath(root);
        return max;
    }

    private void maxpath(TreeNode root) {
        if (root == null) return;

        int leftmax =Math.max(0, childpath(root.left));
        int rightmax =Math.max(0, childpath(root.right));

        max = Math.max(max, root.val + leftmax + rightmax);

        maxpath(root.left);
        maxpath(root.right);
    }

    private int childpath(TreeNode root) {
        if (root == null) return 0;

        int leftsum = childpath(root.left);
        int rightsum = childpath(root.right);

        return root.val + Math.max(0, Math.max(leftsum, rightsum));
    }
}