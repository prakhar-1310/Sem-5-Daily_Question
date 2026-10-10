import java.util.HashMap;

class LFUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int val;
        int freq;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DLL {
        Node head;
        Node tail;
        int size;

        public DLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public void insert(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        public Node removeLRU() {
            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    HashMap<Integer, Node> map;
    HashMap<Integer, DLL> freqMap;

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void updateFreq(Node node) {
        int oldFreq = node.freq;

        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DLL newList = freqMap.get(node.freq);

        if (newList == null) {
            newList = new DLL();
            freqMap.put(node.freq, newList);
        }

        newList.insert(node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        updateFreq(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateFreq(node);
            return;
        }

        if (map.size() == capacity) {
            DLL list = freqMap.get(minFreq);
            Node lru = list.removeLRU();

            map.remove(lru.key);
        }

        Node node = new Node(key, value);

        DLL list = freqMap.get(1);

        if (list == null) {
            list = new DLL();
            freqMap.put(1, list);
        }

        list.insert(node);
        map.put(key, node);

        minFreq = 1;
    }
}