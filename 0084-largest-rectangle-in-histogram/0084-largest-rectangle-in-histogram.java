class Solution {
    public int largestRectangleArea(int[] heights) {
        //stack to store PSE(index) -> Privious Smaller Element
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        //start tarvesing each givin bar
        for(int i = 0; i<n; i++){
            // Implemented the PSE code
            // if stack has ele and curr ele is smaller the st.top(PSE) ele that is the our curr is NSE
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                //store that PSE index
                int ele = st.peek();
                st.pop(); //Grabage Collector kar lega java main
            
                //store nse(index)
                int NSE = i; //curr index has NSE so store that index

                //to store the pse, if stack is empty and then there is no PSE(index) so put -1 as PSE index, otherwise our curr ele is PSE accorinding to while condtionds
                int PSE = st.isEmpty() ? -1 : st.peek();

                //calculate the total area hight[ele](at that percticular index) * width
                int totalArea = heights[ele] * (NSE - PSE - 1);
                //find the maximum area
                maxArea = Math.max(totalArea, maxArea);

            }
            //push the indecs not and element
            st.push(i);
        }
        //if some ele is left over in stack means there no NSE(index) so put NSE(index) as n
          
        while(!st.isEmpty()){
            int NSE = n;
            int ele = st.peek();
            st.pop();
            int PSE = st.isEmpty() ? -1 : st.peek();
            int totalArea = heights[ele] * (NSE - PSE - 1);
            maxArea = Math.max(totalArea, maxArea);
        }
        
    return maxArea;
    }
}