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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int arr[], int st, int ed){
        if(st>ed){
            return null;
        }
        int mid = st + (ed-st)/2;
        TreeNode n = new TreeNode();
        n.val = arr[mid];
        n.left = helper(arr,st,mid-1);
        n.right = helper(arr,mid+1,ed);
        return n;
    }
}