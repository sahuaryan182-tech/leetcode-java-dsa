class StockSpanner {
   Stack<int[]> st = new Stack<>(); //-> {value/ele, index}{0-> val, 1-> ele}
   int index = -1;
    public StockSpanner() {
       index = -1;
    }
    
    public int next(int price) {
        index = index + 1;
        //pop the element in the stack until we find greater element -PGE(privious grator element)
        while(!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }
        //if stack is empty , that means no greator element in stack so set -> -1
        // Otherwise, PGE index = st.peek()[1]
        int ans = index -(st.isEmpty() ? -1 : st.peek()[1]);

        //push val and index in stack
        st.push(new int[]{price, index});


        
        return ans;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */