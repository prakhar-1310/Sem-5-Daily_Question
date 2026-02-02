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
    public int getDecimalValue(ListNode head) {
        // reverse the linked list
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }



        int dec =0;
        int mul = 1;
        while (prev!=null){
            int rem = prev.val;
            dec = dec + mul*rem;
            mul*= 2;
            prev = prev.next;
        }
        return dec;
    }
}