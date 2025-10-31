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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow= head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode nn = new ListNode();
        ListNode temp = nn;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                ListNode n = new ListNode(temp1.val);
                temp.next = n;
                temp = temp.next;
                temp1 = temp1.next;
            }
            else{
                ListNode n = new ListNode(temp2.val);
                temp.next = n;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }

        if(temp1!=null){
            temp.next = temp1;
        }
        else{
            temp.next=temp2;
        }

        return nn.next;
    }
}//206,21,876,141,19,234,
//23,138,25,430