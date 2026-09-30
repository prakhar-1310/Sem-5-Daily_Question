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
    public TreeNode pruneTree(TreeNode root) {
        return helper(root)==true?root:null;
    }

    public boolean helper(TreeNode root){
        if(root.left==null && root.right==null){
            if(root.val==1){
                return true;
            }
            return false;
        }

        boolean left = false;
        if(root.left!=null){
            left = helper(root.left);
        }

        if(left==false)root.left=null;

        boolean right = false;
        if(root.right!=null){
            right = helper(root.right);
        }
        if(right==false)root.right=null;
        boolean self = root.val==1?true:false;
        return left|(right|self);
    }
}