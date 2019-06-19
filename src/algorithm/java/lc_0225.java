class MyStack {
    private Queue<Integer> qi;
    private Queue<Integer> qo;

    /** Initialize your data structure here. */
    public MyStack() {
        qi = new LinkedList<>();
        qo = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(qi.isEmpty()) {
            qi.add(x);
            return;
        }
        qi_to_qo();
        qi.add(x);
        qo_to_qi();
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return qi.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return qi.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return (qo.isEmpty() && qi.isEmpty());
    }
    
    public void qi_to_qo(){
        if(qi.isEmpty()) return;
        while(!qi.isEmpty()) {
            qo.add(qi.poll());
        }
    }
    
    public void qo_to_qi(){
        if(qo.isEmpty()) return;
        while(!qo.isEmpty()) {
            qi.add(qo.poll());
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
