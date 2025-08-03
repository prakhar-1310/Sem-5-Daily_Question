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
    public boolean isValidBST(TreeNode root) {
        return validBST(root).isbst;
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
        sp.isbst = lp.isbst && rp.isbst && lp.max<root.val && rp.min>root.val;
        return sp;
    }
    class bstPair{
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        boolean isbst = true; // single node is always bst
    }
}