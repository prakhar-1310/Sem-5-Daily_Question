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
class Solution {
    public int pairSum(ListNode head) {
        int max=Integer.MIN_VALUE;

        ListNode rev= new ListNode();
        ListNode temp = head;
        ListNode curr = rev;
        while(temp!=null){
            ListNode ls = new ListNode();
            ls.val = temp.val;
            curr.next = ls;
            curr=ls;
            temp=temp.next;
        }
        rev = rev.next;
        curr = rev;
        ListNode prev = null;


        while(curr!=null){
            ListNode ahead = curr.next;
            curr.next=prev;
            prev = curr;
            curr = ahead;
        }

        rev = prev;

        while(rev!=null){
            int valu = rev.val + head.val;
            System.out.println(rev.val+" "+head.val);
            max = Math.max(max, valu);
            rev = rev.next;
            head=head.next;
        }

        return max;

    }
}