class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        // p and q found in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // something found in left subtree
        if (left != null) {
            return left;
        }

        // something found in right subtree
        if (right != null) {
            return right;
        }

        // nothing found
        return null;
    }
}