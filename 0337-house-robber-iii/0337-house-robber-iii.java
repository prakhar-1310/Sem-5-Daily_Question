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
    HashMap<TreeNode, Integer>map;

    public int rob(TreeNode root) {
        map = new HashMap<>();
        return rob1(root);
    }

    public int rob1(TreeNode root) {

        if(root==null){
            return 0;
        }

        if(map.containsKey(root))return map.get(root);

        //rob
        int opt1 = root.val;
        if(root.left !=null){
            opt1+=rob1(root.left.left)+rob1(root.left.right);
        }
        if(root.right!=null){
            opt1+=rob1(root.right.left)+rob1(root.right.right);
        }

        // dont rob

        int opt2=0;
        opt2 = rob1(root.left)+rob1(root.right);

        map.put(root, Math.max(opt1, opt2));
        return Math.max(opt1, opt2);
    }
}