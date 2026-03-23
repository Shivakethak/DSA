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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelorder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return levelorder;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            ArrayList<Integer> levelnodes = new ArrayList<>();
            for(int i =0;i<levelsize;i++){
                TreeNode left = queue.peek().left;
                TreeNode right = queue.peek().right;
                if(left!=null) queue.add(left);
                if(right!=null) queue.add(right);
                levelnodes.add(queue.poll().val);
            }
            levelorder.add(levelnodes);
        }
        return levelorder;
    }
}