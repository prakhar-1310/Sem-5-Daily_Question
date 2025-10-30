class MinStack {
    Stack<Integer>st1;
    Stack<Integer>min;
    public MinStack() {
        st1 = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st1.push(val);
        if(min.isEmpty() || min.peek()>=val){
            min.push(val);
        }
    }
    
    public void pop() {
        if(!st1.isEmpty()){
            int val = st1.pop();
            if(val == min.peek()){
                min.pop();
            }
        }
    }
    
    public int top() {
        if(!st1.isEmpty()){
            return st1.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!min.isEmpty()){
            return min.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */