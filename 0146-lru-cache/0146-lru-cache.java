class LRUCache {

    class Node{
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node>map;
    int n;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        n = capacity;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            map.remove(key);
            n++;
        }
        else if(n==0){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
            n++;
        }

        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);
        n--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */