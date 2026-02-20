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
        helper(root,k);
        return nn.val;
    }
    TreeNode nn = new TreeNode();
    int cnt=1;

    public void helper(TreeNode node, int k){
        if(node == null){
            return;
        }

        helper(node.left,k);

        if(k==cnt){
            nn = node;
            cnt++;
            return;
        }
        cnt++;

        helper(node.right,k);
    }
}