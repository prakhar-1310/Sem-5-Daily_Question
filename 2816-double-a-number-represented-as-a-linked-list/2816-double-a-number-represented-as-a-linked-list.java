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
    public ListNode doubleIt(ListNode head) {
        // return reverse(head);
        ListNode newHead = reverse(head);
        int carry = 0;
        ListNode temp = newHead;
        while(temp!=null){
            int dou = temp.val*2 + carry;
            int val=dou%10;
            carry = dou/10;
            temp.val = val;
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }

        if(carry!=0){
            ListNode nn = new ListNode();
            nn.val = carry;
            temp.next=nn;
            nn.next=null;
        }

        return reverse(newHead);
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode ahead = curr.next;
            curr.next=prev;
            prev=curr;
            curr=ahead;
        }

        return prev;
    }
}