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
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return tot;
    }
    int tot=0;

    public void helper(TreeNode root, int num){
        if(root == null){
            return;
        }

        if(root.left==null && root.right==null){
            tot+=(num*10+root.val);
            return;
        }

        helper(root.left,num*10+root.val);
        helper(root.right,num*10+root.val);
    }
}