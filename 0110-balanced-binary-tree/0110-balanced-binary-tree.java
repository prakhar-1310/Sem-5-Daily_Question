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
    public boolean isBalanced(TreeNode root) {
        return balanced(root).bal;
    }
    public pair balanced(TreeNode root){
        if(root == null){
            return new pair();
        }
        pair lbp = balanced(root.left);
        pair rbp = balanced(root.right);
        pair self = new pair();
        self.ht = Math.max(lbp.ht,rbp.ht)+1;
        boolean balan = Math.abs(lbp.ht-rbp.ht)<=1;
        self.bal = balan && lbp.bal && rbp.bal;

        return self;
    }
    class pair{
        int ht=-1;
        boolean bal = true;
    }
}