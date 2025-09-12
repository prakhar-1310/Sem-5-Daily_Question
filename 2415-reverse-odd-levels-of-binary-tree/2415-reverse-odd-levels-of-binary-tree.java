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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root.left==null || root.right==null){
            return root;
        }
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        int level=1;
        while(!q.isEmpty()){
            int size = q.size();
            
            
                List<TreeNode>list=new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode node = q.poll();
                    list.add(node);
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
                }
                if(level%2==0){
                    int st = 0;
                    int ed = list.size()-1;
                    while(st<ed){
                        int temp = list.get(st).val;
                        list.get(st).val = list.get(ed).val;
                        list.get(ed).val = temp;
                        st++;
                        ed--;
                    }
                }
                
            
            level++;
        }
    }
}