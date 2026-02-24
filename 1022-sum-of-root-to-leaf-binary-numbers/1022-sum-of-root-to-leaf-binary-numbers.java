class Solution {
    public int sumRootToLeaf(TreeNode root) {
        helper(root,0);
        return sum;
    }
    int sum = 0;
    public void helper(TreeNode root, int n){
        if(root.left == null && root.right == null){
            sum+=(n<<1)|root.val;
            return;
        }
        n=(n<<1)|root.val;
        if(root.left!=null){
            helper(root.left,n);
        }
        if(root.right!=null){
            helper(root.right,n);
        }
        
    }
}