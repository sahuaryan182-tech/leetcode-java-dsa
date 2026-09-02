class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        //backword traversing
        // Traverse 2*n time because givin arry is circular way, circular war ->  0 to n , again 0  to n
        // The second traversal lets the elements at the end see elements at the beginning.
        // Circular array → two traversals.
        for(int i = 2 * n-1; i>=0; i--){

            // WHY  i % n
            // when i become grater the n - 1, we need to come back to index 0
            // converts our 2 * n traversel into valid array indices
            int index = i % n;

            //now remove the smaller element the nums[i] from stack
            while(!st.isEmpty() && st.peek() <= nums[index]){
                //remove the smaller element
                st.pop();
            }

            //we only fill the ans during the frist traversal
            if(i < n){

            //if stack is empty , since we traveer from the rigth or backward side
            if(st.isEmpty()){
                nge[index] = -1;
            }
            else{
                //now remove the larger element the nums[i] and put  in the , in nge[i] we used to build our ans arry[] se we return 
                nge[index] = st.peek(); 
            }
            }


            //add or insertd the given arr
            st.push(nums[index]);

        }
        return nge;


        

    }
}