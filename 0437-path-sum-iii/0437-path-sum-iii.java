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
    public int pathSum(TreeNode root, int targetSum) {
        int tot=0;
        if(root==null){
            return 0;
        }
        tot+=helper(root,targetSum,0L);
        tot+=pathSum(root.left,targetSum);
        tot+=pathSum(root.right,targetSum);

        return tot;
    }

    public int helper(TreeNode root, int tar, long sum){
        if(root==null){
            return 0;
        }
        int ans=0;
        if(sum+root.val==tar){
            ans++;
        }

        ans+= helper(root.left,tar,sum+root.val);
        ans+= helper(root.right,tar,sum+root.val);

        return ans;
        
    }
}