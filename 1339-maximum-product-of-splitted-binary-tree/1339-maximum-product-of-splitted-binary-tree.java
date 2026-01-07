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
    private long totalSum = 0;
    private long ans = 0;
    private static final int MOD = 1_000_000_007;

    // First DFS: compute total sum of the tree
    private long buildSubtreeSum(TreeNode root) {
        if (root == null) return 0;

        long left = buildSubtreeSum(root.left);
        long right = buildSubtreeSum(root.right);

        return left + right + root.val;
    }

    // Second DFS: try all possible splits
    private long traverse(TreeNode root) {
        if (root == null) return 0;

        long left = traverse(root.left);
        long right = traverse(root.right);

        if (root.left != null) {
            ans = Math.max(ans, left * (totalSum - left));
        }

        if (root.right != null) {
            ans = Math.max(ans, right * (totalSum - right));
        }

        return left + right + root.val;
    }

    public int maxProduct(TreeNode root) {
        totalSum = buildSubtreeSum(root);
        traverse(root);
        return (int)(ans % MOD);
    }
}