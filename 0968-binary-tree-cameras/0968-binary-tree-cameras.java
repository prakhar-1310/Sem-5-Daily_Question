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
    int Camera =0;
    public int minCameraCover(TreeNode root) {
        int c = minCamera(root);
        if(c==-1){
            Camera++;
        }
        return Camera;
    }
    public int minCamera(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = minCamera(root.left);
        int right = minCamera(root.right);
        if(left==-1 || right == -1){ // -1 means camera required
            Camera++;
            return 1; // camera setup kra h is node pr
        }
        if (left==1 || right == 1){ // inme m kiski ek ke pas ya dono ke pas camera h 
            return 0; // means covered
        }
        else{
            return -1;// need a camera
        }

    }
}