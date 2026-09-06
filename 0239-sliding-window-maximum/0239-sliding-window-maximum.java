class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //deque to store the indeces
        Deque<Integer> dq = new LinkedList<>();
        //to store th refence value
        int[] result  = new int[n-k+1];
        int index = 0;

        //start travesing 
        for(int i = 0; i<n; i++){
            //cheak if some one is not our window, remove indeces out of current window
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){               
                dq.pollFirst();
            }

            //make sure need to maintain greateor ele
            //maintain the deque decresing order , monotonic order
            //remove the smaller value form the back of deque
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            //add the curr indeces
            dq.offerLast(i);

            //add the result once the frist window is formed
            if(i>=k-1){
                result[index] = nums[dq.peekFirst()];
                index++;
            }
        }
        return result;
    }
}