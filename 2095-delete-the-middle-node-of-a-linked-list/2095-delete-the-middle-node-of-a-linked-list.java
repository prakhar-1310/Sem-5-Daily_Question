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
    public ListNode deleteMiddle(ListNode head) {
        int size=0;
        ListNode temp = head;
        while (temp!=null){
            size++;
            temp = temp.next;
        }

        int n = size/2;
        if (n==0){
            return null;
        }
        size =0;
        temp = head;
        for (int i=0;i<n-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}