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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        helper(ans,root);
        List<List<Integer>>ll = new ArrayList<>();
        for(int i=ans.size()-1;i>=0;i--){
            ll.add(ans.get(i));
        }
        return ll;
    }

    public void helper(List<List<Integer>>ans, TreeNode root){
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode n = q.poll();
                list.add(n.val);
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
            }
            ans.add(list);
        }
    }
}