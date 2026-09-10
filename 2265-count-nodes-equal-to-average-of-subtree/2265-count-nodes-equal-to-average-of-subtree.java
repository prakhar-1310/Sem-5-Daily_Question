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
    public int averageOfSubtree(TreeNode root) {
        return helper(root).ans;
    }

    public Pair helper(TreeNode root){
        if(root.left==null & root.right==null){
            return new Pair(root.val, 1, 1);
        }

        if(root.left==null){
            Pair right = helper(root.right);
            if((right.sum+root.val)/(right.cnt+1)==root.val){
                return new Pair(right.sum+root.val, right.cnt+1, right.ans+1);
            }

            return new Pair(right.sum+root.val, right.cnt+1, right.ans);
        }

        if(root.right==null){
            Pair left = helper(root.left);
            if((left.sum+root.val)/(left.cnt+1)==root.val){
                return new Pair(left.sum+root.val, left.cnt+1, left.ans+1);
            }

            return new Pair(left.sum+root.val, left.cnt+1, left.ans);
        }

        Pair right = helper(root.right);
        Pair left = helper(root.left);

        if((left.sum+right.sum+root.val)/(left.cnt+right.cnt+1)==root.val){
            return new Pair(right.sum+left.sum+root.val, right.cnt+left.cnt+1, left.ans+right.ans+1);
        }

        return new Pair(left.sum+right.sum+root.val, left.cnt+right.cnt+1, left.ans+right.ans);

    }



    class Pair{
        int sum;
        int cnt;
        int ans;

        public Pair(int sum, int cnt, int ans){
            this.sum = sum;
            this.cnt = cnt;
            this.ans = ans;
        }
    }
}