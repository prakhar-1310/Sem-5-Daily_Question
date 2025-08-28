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
    public boolean checkTree(TreeNode root) {
        if ((root.left ==null && root.right == null)){
            return true;
        }

        boolean left = checkTree(root.left);
        boolean right = checkTree(root.right);

        boolean check = (root.val == (root.right.val + root.left.val));
        
        return left && right && check;

    }
}