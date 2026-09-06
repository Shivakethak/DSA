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
class Pair{
    TreeNode node;
    int steps;
    Pair(TreeNode node,int steps){
        this.node = node;
        this.steps = steps;
    }
}
class Solution {
    Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
    Map<TreeNode,Boolean> vis = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        int max = 0;
        TreeNode Start = findstartnode(root,start);
        createAdj(root);
        Queue<Pair> q = new LinkedList<>();
        vis.put(Start,true);
        q.add(new Pair(Start,0));
        while(!q.isEmpty()){
            TreeNode node = q.peek().node;
            int steps= q.peek().steps;
            q.poll();
            List<TreeNode> neigh = adj.get(node);
            for(int i=0;i<neigh.size();i++){
             TreeNode neighbour = neigh.get(i);
             if(vis.get(neighbour)!=true){
                q.offer(new Pair(neighbour,steps+1));
                vis.put(neighbour,true);
                max = Math.max(max,steps+1);
             }
            }
        }
        return max;

    }
    private TreeNode findstartnode(TreeNode root,int start){
    if(root==null) return null;
    if(root.val==start) return root;
    TreeNode left = findstartnode(root.left,start);
    if(left!=null) return left;
    return findstartnode(root.right,start);
    }

    private void createAdj (TreeNode root){
    if (root == null) return;
    adj.putIfAbsent(root, new ArrayList<>());
    vis.putIfAbsent(root,false);
    if (root.left != null) {
        adj.putIfAbsent(root.left, new ArrayList<>());

        adj.get(root).add(root.left);
        adj.get(root.left).add(root);   // child → parent

        createAdj(root.left);
    }
    if (root.right != null) {
        adj.putIfAbsent(root.right, new ArrayList<>());

        adj.get(root).add(root.right);
        adj.get(root.right).add(root);  // child → parent
        createAdj(root.right);
    }
}
     
}