class MinStack {
    Stack<int []> st = new Stack<>(); //w store a int arr pair in the stack 
    //pair -> (value , currnt seen minunmun value)

    public MinStack() {
        
    }
    
    public void push(int value) {
        //if stack is empty -> means there is no val , means frist value so push and minimun is the same value till we see
        if(st.isEmpty()){
            st.push(new int []{value, value});
        }
        // if not mans there is an alredy pair =-> (value, min value we seen till last seen)
        else{
            int currSeen = Math.min(value, st.peek()[1]);
            st.push(new int []{value, currSeen});
        }
        
    }
    
    public void pop() {
        st.pop(); //delete the whole pair
        
    }
    
    public int top() {
        return st.peek()[0]; //because we store the arr in pair in the stack , need top only value not currnt seen
        
    }
    
    public int getMin() {
        return st.peek()[1];
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */