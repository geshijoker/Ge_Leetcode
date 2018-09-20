class LFUCache {
    class DoubleLinkedNode {
        DoubleLinkedNode next;
        DoubleLinkedNode pre;
        int key;
        int value;
        int freq;
        
        DoubleLinkedNode(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            next = null;
            pre = null;
        }
    }
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    Map<Integer, DoubleLinkedNode> map;
    Map<Integer, DoubleLinkedNode> freqMap;
    int capacity;

    public LFUCache(int capacity) {
        head = new DoubleLinkedNode(0,0,Integer.MAX_VALUE);
        tail = new DoubleLinkedNode(0,0,0);
        head.next = tail;
        tail.pre = head;
        
        map = new HashMap<Integer, DoubleLinkedNode>();
        freqMap = new HashMap<Integer, DoubleLinkedNode>();
        freqMap.put(0,tail);
        this.capacity = capacity;
    }
    
    public DoubleLinkedNode delete(DoubleLinkedNode node) {
        DoubleLinkedNode preNode = node.pre;
        DoubleLinkedNode nextNode = node.next;
        if(node==freqMap.get(node.freq)) {
            freqMap.remove(node.freq);
            freqMap.put(nextNode.freq,nextNode);
        }
        preNode.next = nextNode;
        nextNode.pre = preNode;
        return nextNode;
    }
    
    public void offer(DoubleLinkedNode node, DoubleLinkedNode nextNode) {
        DoubleLinkedNode preNode;
        preNode = nextNode.pre;
        preNode.next = node;
        node.next = nextNode;
        nextNode.pre = node;
        node.pre = preNode;
        freqMap.put(node.freq,node);
    }
    
    public int get(int key) {
        if(capacity==0)
            return -1;
        if(!map.containsKey(key)) return -1;
        DoubleLinkedNode node = map.get(key);
        DoubleLinkedNode nextNode = delete(node);
        if(freqMap.containsKey(node.freq))
            nextNode = freqMap.get(node.freq);
        if(freqMap.containsKey(++node.freq)) {
            offer(node, freqMap.get(node.freq));
        }else {
            offer(node, nextNode);
        }
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0)
            return;
        DoubleLinkedNode node;
        if(map.containsKey(key)) {
            int freq = map.get(key).freq;
            DoubleLinkedNode nextNode = delete(map.get(key));
            node = new DoubleLinkedNode(key,value,freq);
            if(freqMap.containsKey(node.freq))
                nextNode = freqMap.get(node.freq);
            if(freqMap.containsKey(++node.freq)) {
                offer(node, freqMap.get(node.freq));
            }else {
                offer(node, nextNode);
            }
            map.put(key, node);
            return;
        }
        if(map.size()>=capacity) {
            map.remove(tail.pre.key);
            delete(tail.pre);
        }
        node = new DoubleLinkedNode(key, value, 0);
        if(freqMap.containsKey(++node.freq)) {
            offer(node, freqMap.get(node.freq));
        }else {
            offer(node, tail);
        }
        map.put(key, node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
