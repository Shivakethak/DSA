/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public boolean isBST(Node root) {
      return bst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean bst(Node node,int min,int max){
        if(node== null) return true;
        if(node.data <= min || node.data >= max) return false;
        boolean left = bst(node.left,min,node.data);
        boolean right = bst(node.right,node.data,max);
        return left && right;
    }
}