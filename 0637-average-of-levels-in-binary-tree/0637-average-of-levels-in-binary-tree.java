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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>list = new ArrayList<>();
        if(root==null){
            return list;
        }
        helper(root,list);
        return list;
    }
    public void helper(TreeNode root, List<Double>list){
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Double sum = 0.0;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode n = q.poll();
                sum+=n.val;
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
            }
            list.add(sum/size);
        }
    }
}