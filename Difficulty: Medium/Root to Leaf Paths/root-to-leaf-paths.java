/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    ArrayList<ArrayList<Integer>> paths =  new ArrayList<>();
    public ArrayList<ArrayList<Integer>> paths(Node root) {
       ArrayList<Integer> path = new ArrayList<>();
       paths(root,path);
       return paths;
    }
    private void paths(Node root,ArrayList<Integer>  path){
        if(root==null) return ;
        path.add(root.data);
        paths(root.left,path);
        paths(root.right,path);
        if(root.left==null && root.right==null) {
            paths.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
    }
    path.remove(path.size()-1);
    return;
    }
}