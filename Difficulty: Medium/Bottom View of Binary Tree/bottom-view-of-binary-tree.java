/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/
class Pair{
    Node node;
    int line;
    Pair(Node node,int line){
        this.node  = node;
        this.line = line ;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
       Queue<Pair> q = new LinkedList<>();
       Map<Integer,Integer> map = new TreeMap<>();
       q.add(new Pair(root,0));
       while(!q.isEmpty()){
           Node node = q.peek().node;
           int line = q.peek().line;
           q.poll();
           map.put(line,node.data);
           if(node.left!=null) q.offer(new Pair(node.left,line-1));
           if(node.right!=null) q.offer(new Pair(node.right,line+1));
       }
       ArrayList<Integer> BottomView = new ArrayList<>();
       for(int key : map.keySet()){
           BottomView.add(map.get(key));
       }
        return BottomView;
    }
}