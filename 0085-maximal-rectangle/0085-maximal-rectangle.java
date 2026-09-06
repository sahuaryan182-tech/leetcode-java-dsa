class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length; //row number
        int m = matrix[0].length; //colum number
        int maxArea = 0;
        //Edge case: if Matrix is empty return 0
        if(matrix.length == 0 || matrix[0].length  == 0) return 0;
        //not change orignal givin 2D arr, need prefixsum arr
        int[][] PrefixSum = new int[n][m];
        //number of row will increase, then colum change ho raha hai
        for(int j = 0; j<m; j++){
            int sum = 0;
            for(int i = 0; i<n; i++){
               
                if(matrix[i][j] == '1'){
                    //make sure sum is re-initllize is zero
                    sum = sum + 1;
                }
                else{
                    sum = 0;
                }
                PrefixSum[i][j] = sum; //prefix sum matrix is ready
            }
        }
       //compute all the rows
       for(int i = 0; i<n; i++){
        maxArea = Math.max(maxArea, LargestHistoGram(PrefixSum[i])); // here we pass the only row[0 to n-1] of prefixsum matrix as array
       }
       return maxArea;

    }
    //pre compute the Lasgest Rectangle in Histogarm 
    private int LargestHistoGram(int[] heights){
        Stack<Integer> st = new Stack<>(); //store PSE(index)
        int n = heights.length;
        int maxArea = 0;
        
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int ele = st.peek(); //PSE(index)
                st.pop();

                int NSE = i; //NSE(index) is our curr ele index
                int PSE = st.isEmpty() ? -1 : st.peek(); //PSE(index) is stack top(because stack store only PSE(index) maintain the Incresing order)

                int totalArea = heights[ele] * (NSE - PSE - 1);
                maxArea = Math.max(maxArea, totalArea);

            }
            //push indexces in stack
            st.push(i);
        }
        //if there is ele in leftover into stack , so there is no NSE
        while(!st.isEmpty()){
            int NSE = n; 
            int ele = st.peek();
            st.pop();
            //if there is no PSE so set to -1 
            int PSE = st.isEmpty() ? -1 : st.peek();
            int totalArea = heights[ele] * (NSE - PSE -1);
            maxArea = Math.max(maxArea, totalArea);

        }
        return maxArea;

    }
}