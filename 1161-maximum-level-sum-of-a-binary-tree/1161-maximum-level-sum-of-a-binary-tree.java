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
    public int maxLevelSum(TreeNode root) {
        int ans=0;
        TreeNode head = root;
        Queue<TreeNode>q = new LinkedList<>();
        q.add(head);

        int sum=0;
        int total=Integer.MIN_VALUE;
        int size=q.size();
        int cnt=0;
        int level=1;
        while(!q.isEmpty()){
            TreeNode n = q.poll();

            sum+=n.val;
            cnt++;

            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }

            if(cnt==size){
                cnt=0;
                size = q.size();
                if(sum>total){
                    total=sum;
                    ans=level;
                }
                level++;
                sum=0;
            }
        }
        return ans;
    }
}