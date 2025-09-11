/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer>list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }

        return helper(list,0,list.size()-1);
    }

    public TreeNode helper(List<Integer>list, int st, int ed){
        if(st>ed){
            return null;
        }
        int mid = st + (ed-st)/2;
        TreeNode n = new TreeNode();
        n.val = list.get(mid);
        n.left = helper(list, st,mid-1);
        n.right = helper(list,mid+1,ed);
        return n;
    }
}