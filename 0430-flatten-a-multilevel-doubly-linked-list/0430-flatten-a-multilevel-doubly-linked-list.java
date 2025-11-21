/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        Stack<Node>st = new Stack<>();
        while(temp!=null){
            if(temp.child!=null){
                if(temp.next!=null){
                    st.push(temp.next);
                }
                temp.next=temp.child;
                temp.child=null;
                temp.next.prev = temp;
            }
            if(!st.isEmpty() && temp.next==null){
                temp.next=st.pop();
                temp.next.prev = temp;
            }
            temp=temp.next;
        }

        return head;
        // if (head == null) return null;
        // Node nn = new Node();
        // Node dummy = nn;
        // Node temp = head;
        // while(temp!=null){
        //     if(temp.child!=null){
        //         Node children = flatten(temp.child);
        //         nn.next = children;
        //         children.prev = nn;
        //         temp.child=null;

        //     }

        //     Node nxt = temp.next;

        //     nn.next = temp;
        //     temp.prev = nn;

        //     nn = nn.next;
        //     temp = nxt;
        // }

        // dummy.next.prev = null;
        // return dummy.next;
    }
}