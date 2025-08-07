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
    public int maxSumBST(TreeNode root) {
        return validBST(root).ans;
    }
    public bstPair validBST(TreeNode root){
        if(root==null){
            return new bstPair();
        }
        bstPair lp = validBST(root.left);
        bstPair rp = validBST(root.right);
        bstPair sp = new bstPair();
        sp.max = Math.max(root.val,Math.max(lp.max,rp.max));
        sp.min = Math.min(root.val,Math.min(lp.min,rp.min));
        sp.sum = lp.sum+rp.sum+root.val;
        sp.isbst = lp.isbst && rp.isbst && lp.max<root.val && rp.min>root.val;
        if(sp.isbst){
            sp.ans = Math.max(sp.sum,Math.max(lp.ans,rp.ans));
        }
        else{
            sp.ans = Math.max(lp.ans,rp.ans);
        }
        return sp;
    }
    class bstPair{
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        boolean isbst = true; // single node is always bst
        int sum=0;
        int ans = 0 ; // only bst part sum
    }
}