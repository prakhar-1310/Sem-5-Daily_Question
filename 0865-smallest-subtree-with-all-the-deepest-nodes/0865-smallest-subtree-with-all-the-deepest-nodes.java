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

    public int dept(TreeNode root) {
        if (root == null) return -1;
        return Math.max(dept(root.left), dept(root.right)) + 1;
    }

    ArrayList<ArrayList<TreeNode>> al = new ArrayList<>();
    int deep;

    public void path(ArrayList<TreeNode> curr, TreeNode root, int d) {
        if (root == null) return;

        curr.add(root);

        if (d == deep) {
            al.add(new ArrayList<>(curr));
        } else {
            path(curr, root.left, d + 1);
            path(curr, root.right, d + 1);
        }

        curr.remove(curr.size() - 1);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;

        deep = dept(root);
        path(new ArrayList<>(), root, 0);

        ArrayList<TreeNode> base = al.get(0);
        int idx = 0;

        while (idx < base.size()) {
            TreeNode node = base.get(idx);
            for (ArrayList<TreeNode> p : al) {
                if (p.get(idx) != node) {
                    return base.get(idx - 1);
                }
            }
            idx++;
        }

        return base.get(base.size() - 1);
    }
}