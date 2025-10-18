/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }

        Node left = root.left;
        Node right = root.right;
        Node next = root.next;

        if(left!=null){// means node have both child
            left.next=right;
            if(next!=null){
                right.next=next.left;
            }
            connect(left);
            connect(right);
        }

        return root;
    }
}