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
    List<String> paths = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        paths(root,"");
        return paths;
    }
    private void paths(TreeNode root,String path){
        if(root==null){ 
            return;
        }
        path +=root.val;
        if(root.left==null && root.right==null) {
            paths.add(path);
        }
        path+="->";
        paths(root.left,path);
        paths(root.right,path);
    }
}