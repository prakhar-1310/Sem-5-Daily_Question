  class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        helper(0,targetSum,root,list,ans);
        return ans;
    }

    public void helper(int curr, int target,TreeNode root, List<Integer>list,List<List<Integer>>ans){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(curr+root.val==target && root.left==null && root.right==null){
            ans.add(new ArrayList<>(list));
        }
        else{
            helper(curr+root.val, target,root.left,list,ans);
            helper(curr+root.val, target,root.right,list,ans);
        }
        
        list.remove(list.size()-1);
    }
}