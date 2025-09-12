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
    public int kthSmallest(TreeNode root, int k) {
        // since inorder traversal gives us sorted node
        // so kth smallest means kth value

        helper(root,k);
        return node.val;
    }
    TreeNode node = null;
    int count=1;
    public void helper(TreeNode root, int k){
        if(root==null){
            return;
        }
        helper(root.left,k);
        
        if(count==k){
            node = root;
            count++;
            return ;
        }
        count++;
        helper(root.right,k);

    }
}