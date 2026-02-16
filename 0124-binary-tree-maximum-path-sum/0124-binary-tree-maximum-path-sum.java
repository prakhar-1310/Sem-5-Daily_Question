class Solution {
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    int max = Integer.MIN_VALUE;
    public int helper(TreeNode nn){
        if(nn == null){
            return 0;
        }

        int l = Math.max(0,helper(nn.left));
        int r = Math.max(0,helper(nn.right));

        max = Math.max(max,l+r+nn.val);

        return nn.val + Math.max(l,r);
    }
}