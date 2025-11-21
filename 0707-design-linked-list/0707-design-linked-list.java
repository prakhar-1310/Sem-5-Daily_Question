class MyLinkedList {
    class Node{
        Node next;
        int val;
    }
    Node head;
    Node tail;
    int size=0;

    public MyLinkedList() {
        head=null;
        tail=null;
        size=0;
    }
    
    public int get(int index) {
        if(index<0 || size<=index){
            return -1;
        }
        int i=0;
        Node temp = head;
        while(i<index){
            i++;
            temp=temp.next;
        }
        return temp.val;
    }    

    public void addAtHead(int val) {
        Node nn = new Node();
        nn.val = val;

        if(size==0){
            head = nn;
            tail= nn;
        }
        else{
            nn.next=head;
            head = nn;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node nn = new Node();
        nn.val = val;

        if(size==0){
            head = nn;
            tail =nn;
        }
        else{
            tail.next=nn;
            tail = nn;
        }
        
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size || index<0){
            return;
        }
        if(size==index){
            addAtTail(val);
            return;
        }
        if(index==0){
            addAtHead(val);
            return;
        }
        int i=0;
        Node temp = head;
        while(i<index-1){
            i++;
            temp=temp.next;
        }
        Node nn = new Node();
        nn.val = val;
        nn.next = temp.next;
        temp.next=nn;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || size<=index){
            return;
        }

        if(index==0){
            head=head.next;
            size--;
            if(size==0){
                tail=null;
            }
            return;
        }

        int i=0;
        Node temp = head;
        while(i<index-1){
            i++;
            temp=temp.next;
        }
        temp.next=temp.next.next;

        if(index==size-1){
            tail = temp;
        }
        
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */