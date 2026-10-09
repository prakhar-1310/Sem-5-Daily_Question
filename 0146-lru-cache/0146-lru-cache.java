class LRUCache {
    HashMap<Integer,Integer>map;
    int size;
    List<Integer>list;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.size = capacity;
        list=new ArrayList<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            list.remove(Integer.valueOf(key));
            list.add(key);
            return map.get(key);
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            list.remove(Integer.valueOf(key));
        }
        else if(map.size()==size){
            int lru = list.remove(0);
            map.remove(lru);
        }
        list.add(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */