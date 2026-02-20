/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }

    public TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        if(node==null){
            return null;
        }

        if(node.val == q.val || node.val == p.val){
            return node;
        }

        TreeNode left = helper(node.left, p,q);
        TreeNode right = helper(node.right, p, q);

        if(left!=null && right!=null){
            return node;
        }

        if(left==null){
            return right;
        }
        else{
            return left;
        }
    }
}