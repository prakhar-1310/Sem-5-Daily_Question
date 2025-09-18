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
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        TreeNode n = create(list,0,list.size()-1);
        return n;
    }
    public List<TreeNode>list = new ArrayList<>();

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    public TreeNode create(List<TreeNode>list, int i, int j){
        if(i>j){
            return null;
        }
        int mid = (i+j)/2;
        TreeNode n = list.get(mid);
        n.left = create(list,i,mid-1);
        n.right = create(list,mid+1,j);
        return n;
    }

}