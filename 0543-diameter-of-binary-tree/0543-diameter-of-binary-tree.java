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
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).dia;
    }

    public DiaPair helper(TreeNode nn){
        if(nn==null){
            return new DiaPair();
        }

        DiaPair ldp = helper(nn.left);
        DiaPair rdp = helper(nn.right);
        DiaPair sp = new DiaPair();
        sp.ht = Math.max(ldp.ht,rdp.ht)+1;
        int dia = ldp.ht+rdp.ht+2;
        sp.dia = Math.max(dia,Math.max(ldp.dia,rdp.dia));

        return sp;
    }

    class DiaPair{
        int ht=-1;
        int dia=0;
    }
}