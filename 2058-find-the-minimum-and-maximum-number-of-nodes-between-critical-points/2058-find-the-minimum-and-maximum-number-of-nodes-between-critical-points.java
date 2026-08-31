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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer>list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int n = list.size();
        List<Integer>cric = new ArrayList<>();
        for(int i=1;i<n-1;i++){
            if(list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1)){
                cric.add(i);
            }
            else if(list.get(i)<list.get(i-1) && list.get(i)<list.get(i+1)){
                cric.add(i);
            }
        }
        if(cric.size()<2) return new int[]{-1,-1};

        int min=Integer.MAX_VALUE;
        for(int i=1;i<cric.size();i++){
            min = Math.min(min, cric.get(i)-cric.get(i-1));
        }

        int max = cric.get(cric.size()-1)-cric.get(0);

        return new int[]{min,max};
    }
}