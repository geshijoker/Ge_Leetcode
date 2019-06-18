class MinStack {
    private Stack<Integer> normal;
    private Stack<Integer> minS;

    /** initialize your data structure here. */
    public MinStack() {
        normal = new Stack<>();
        minS = new Stack<>();
        return;
    }
    
    public void push(int x) {
        normal.push(x);
        if(minS.empty()) minS.push(x);
        else 
            minS.push(Math.min(minS.peek(),x));
    }
    
    public void pop() {
        normal.pop();
        minS.pop();
    }
    
    public int top() {
        return normal.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
