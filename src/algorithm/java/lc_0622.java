class MyCircularQueue {
    private List<Integer> data;         
    // a pointer to indicate the start position
    private int p_start;   
    private int p_end;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new ArrayList<Integer>(k);
        this.p_start = 0;
        this.p_end = 0;
        this.size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull() == true)
            return false;
        //data.set((this.p_end % this.size), value);
        if(this.p_end<size)
            data.add(value);
        else
            data.set((this.p_end % this.size), value);
        this.p_end++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true)
            return false;
        this.p_start++;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        return data.get(this.p_start % this.size);
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        return data.get((this.p_end-1) % this.size);
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(this.p_end<=this.p_start)
            return true;
        else
            return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(this.p_end-this.p_start>=size)
            return true;
        else
            return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
