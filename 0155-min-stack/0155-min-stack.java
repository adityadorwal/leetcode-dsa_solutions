class MinStack {
    Stack <Integer> stk ;
    Stack <Integer> minstk;

    public MinStack() {
        stk=new Stack<>();
        minstk= new Stack<>();
    }
    
    public void push(int val) {
        if(minstk.isEmpty() || minstk.peek()>=val)
        minstk.push(val);
        stk.push(val);
    }
    
    public void pop() {
        if(minstk.peek().equals(stk.peek()))
        minstk.pop();
        stk.pop();
    }
    
    public int top() {
        return(stk.peek());
    }
    
    public int getMin() {
        return(minstk.peek());
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