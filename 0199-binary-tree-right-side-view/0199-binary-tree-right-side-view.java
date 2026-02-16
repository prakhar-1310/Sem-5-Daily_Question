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
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return list;
    }
    HashSet<Integer>set = new HashSet<>();
    List<Integer>list = new ArrayList<>();

    public void helper(TreeNode nn, int cc){
        if(nn==null){
            return;
        }

        if(!set.contains(cc)){
            list.add(nn.val);
            set.add(cc);
        }

        helper(nn.right,cc+1);
        helper(nn.left,cc+1);
    }
}