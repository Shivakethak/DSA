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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null) return preorder;
        s.push(root); 
        while(!s.isEmpty()){
            int Size = s.size();
            for(int i =0;i<Size;i++){
                TreeNode node = s.pop();
                preorder.add(node.val);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(right!=null) s.push(right);
                if(left!=null) s.push(left);
            }
        }
        return preorder;
    }
}