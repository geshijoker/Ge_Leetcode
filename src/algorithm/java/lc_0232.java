class MyQueue {
    private Stack<Integer> sti;
    private Stack<Integer> sto;

    /** Initialize your data structure here. */
    public MyQueue() {
        sti = new Stack<>();
        sto = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        sti.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(sto.isEmpty())
            swap();
        return sto.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(sto.isEmpty())
            swap();
        return sto.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (sto.isEmpty() && sti.isEmpty());
    }
    
    public void swap(){
        if(!sto.isEmpty()) return;
        while(!sti.isEmpty()) {
            sto.push(sti.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
