class LRUCache {
    class DoubleLinkedNode {
        DoubleLinkedNode next;
        DoubleLinkedNode pre;
        int key;
        int value;
        
        DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            pre = null;
        }
    }
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    Map<Integer, DoubleLinkedNode> map;
    int capacity;

    public LRUCache(int capacity) {
        head = new DoubleLinkedNode(0,0);
        tail = new DoubleLinkedNode(0,0);
        head.next = tail;
        tail.pre = head;
        
        map = new HashMap<Integer, DoubleLinkedNode>();
        this.capacity = capacity;
    }
    
    public void delete(DoubleLinkedNode node) {
        DoubleLinkedNode preNode = node.pre;
        DoubleLinkedNode nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }
    
    public void offer(DoubleLinkedNode node) {
        DoubleLinkedNode temp = head.next;
        head.next = node;
        node.next = temp;
        temp.pre = node;
        node.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DoubleLinkedNode node = map.get(key);
        delete(node);
        offer(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DoubleLinkedNode node = new DoubleLinkedNode(key, value);
        if(map.containsKey(key)) {
            delete(map.get(key));
            offer(node);
            map.put(key, node);
            return;
        }
        map.put(key, node);
        offer(node);
        if(map.size()>capacity) {
            map.remove(tail.pre.key);
            delete(tail.pre);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
