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
    public int[] findMode(TreeNode root) {
        helper(root);
        int maxFreq=0;
        for(int i : map.values()){
            maxFreq=Math.max(maxFreq,i);
        }
        List<Integer>list = new ArrayList<>();
        for (int i : map.keySet()){
            if(map.get(i)==maxFreq){
                list.add(i);
            }
        }
        int ans[] = new int [list.size()];
        int i=0;
        for(int n:list){
            ans[i++]=n;
        }
        return ans;

    }

    HashMap<Integer,Integer>map = new HashMap<>();

    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        helper(root.right);
    }
}